package lig.steamer.of4osm.io;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.impl.HighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagKeyConcept;
import lig.steamer.of4osm.util.OF4OSMConceptLabelizer;
import lig.steamer.of4osm.util.OF4OSMTagIdentifier;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIResponse;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIResponseParseText;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public final class OF4OSMOntoReaderOSMMediaWikiAPI {
	
	private static final Logger LOGGER = Logger.getLogger(OF4OSMOntoReaderOSMMediaWikiAPI.class.getName());
	
	public static final String CATEGORY_TAGS_ID = "Primary_features";
	
	public static IOF4OSMOntology read(MediaWikiAPIResponse response, IOF4OSMOntology of4osm){
		
		LOGGER.log(Level.INFO, "Adding tags from the OSM Wiki Map Features Web page to OF4OSM...");
		
		MediaWikiAPIResponseParseText text = response.getParse().getText();
		
		Document htmlDoc = Jsoup.parse(text.getAll());
		
		IOSMTagKey key = null;
		IOSMTagValue value = null;
		IOSMSimpleCategoryTag tag = null;
		IOSMCategoryTagKeyConcept keyConcept = null;
		IHighLevelConcept highLevelConcept = null;
		IOSMCategoryTagConcept tagConcept = null;
		
		Element primaryFeaturesHeader = htmlDoc.getElementById(CATEGORY_TAGS_ID).parent();
		
		for(Element el : primaryFeaturesHeader.siblingElements()){
			
			if(el.tagName().equals("h2")) break;
			
			if(el.tagName().equals("h3")){
			
				key = new OSMTagSimpleKey(el.text(), "");
				keyConcept = new OSMCategoryTagKeyConcept(OF4OSMConceptLabelizer.normalize(key.getValue()), key);
				of4osm.addConcept(keyConcept);
				
				LOGGER.log(Level.INFO, "Adding IOSMCategoryTagKeyConcept \"" + keyConcept.getDefaultLabel() + "\"");
				
				continue;
			}
			
			if(el.hasClass("wikitable")){
				
				List<Element> rows = el.select("tr");
				for(Element row : rows){
					
					Element firstCol = row.children().first();
						
					// is highLevelConcept row
					Element header = firstCol.select("h4 span.mw-headline").first();
					if(header != null){
						
						highLevelConcept = new HighLevelConcept(OF4OSMConceptLabelizer.normalize(header.text()) + keyConcept.getDefaultLabel());
						highLevelConcept.addParent((IHighLevelConceptParent) keyConcept);
						of4osm.addConcept(highLevelConcept);
						
						LOGGER.log(Level.INFO, "Adding HighLevelConcept \"" + highLevelConcept.getDefaultLabel() + "\"");			
					} else {
						
						Element valueCol = row.select("td a[title^='Tag:']").first();
						if(valueCol != null){
							
							value = OF4OSMTagIdentifier.identifyValue(valueCol.text());
							
							if(key != null){
								if(OF4OSMTagIdentifier.identifyTag(key, value) instanceof OSMSimpleCategoryTag){
									tag = (OSMSimpleCategoryTag) OF4OSMTagIdentifier.identifyTag(key, value);
									String label = OF4OSMConceptLabelizer.getLabelFromTag(tag);
									
									tagConcept = new OSMCategoryTagConcept(label, tag, (IOSMTagConceptParent) keyConcept);
									if(highLevelConcept != null){
										tagConcept.addParent((IOSMTagConceptParent) highLevelConcept);
									}
									of4osm.addConcept(tagConcept);
									
									LOGGER.log(Level.INFO, "Adding IOSMCategoryTagConcept \"" + tagConcept.getDefaultLabel() + "\"");
								}
							}
						}
					}
				}
			}
		}
		
		LOGGER.log(Level.INFO, "Adding tags from the OSM Wiki Map Features Web page to OF4OSM done.");
		
		LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagKeyConcept instances: " + of4osm.getOSMCategoryTagKeyConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IHighLevelConcept instances: " + of4osm.getHighLevelConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagConcept instances: " + of4osm.getOSMCategoryTagConcepts().size());
		
		return of4osm;
	}
	
}
