package lig.steamer.of4osm.io;

import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;
import lig.steamer.of4osm.core.onto.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;
import lig.steamer.of4osm.util.OF4OSMConceptFactory;
import lig.steamer.of4osm.util.OF4OSMTagIdentifier;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIResponse;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIResponseParseText;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public final class OF4OSMOntoReaderOSMMediaWikiAPI {
	
	private static final Logger LOGGER = Logger.getLogger(OF4OSMOntoReaderOSMMediaWikiAPI.class.getName());
	
	public static final String CATEGORY_TAGS_ID = "Primary_features";
	public static final String ADDITIONAL_PROP_ID = "Additional_properties";
	
	public static final String CSS_SELECTOR_TABLE_CLASS = "wikitable";
	public static final String CSS_SELECTOR_TR = "tr";
	
	public static final String CSS_SELECTOR_OSMTAGKEYCONCEPT = "h3";
	public static final String CSS_SELECTOR_HIGHLEVELCONCEPT = "h4 span.mw-headline";
	public static final String CSS_SELECTOR_KEY = "td a[title^='Key:']";
	public static final String CSS_SELECTOR_TAG = "td a[title^='Tag:']";
	
	public static void read(MediaWikiAPIResponse response, IOF4OSMOntology of4osm){
		
		final long t0 = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "Adding tags from the OSM Wiki Map Features Web page to OF4OSM...");
		
		MediaWikiAPIResponseParseText text = response.getParse().getText();
		
		Document htmlDoc = Jsoup.parse(text.getAll());
		
		IOSMTagKey key = null;
		IOSMTagValue value = null;
		IOSMSimpleCategoryTag tag = null;
		IOSMTagSimpleKeyConcept firstLevelConcept = null;
		IHighLevelConcept secondLevelConcept = null;
		IOSMTagSimpleKeyConcept keyConcept = null;
		IOSMSimpleCategoryTagConcept tagConcept = null;
		
		Element primaryFeaturesHeader = htmlDoc.getElementById(CATEGORY_TAGS_ID).parent();
		
		for(Element el : primaryFeaturesHeader.siblingElements()){
			
			if(el.children().first() != null && el.children().first().id().equals(ADDITIONAL_PROP_ID)) break;
			
			if(el.tagName().equals(CSS_SELECTOR_OSMTAGKEYCONCEPT)){
			
				key = new OSMTagSimpleKey(el.text().toLowerCase().replace(" ", "_"), "");
				firstLevelConcept = OF4OSMConceptFactory.createOSMTagSimpleKeyConcept((IOSMTagSimpleKey) key);
				of4osm.addConcept(firstLevelConcept);
				
				secondLevelConcept = null;
				
				LOGGER.log(Level.INFO, "Adding IOSMCategoryTagKeyConcept \"" + firstLevelConcept.getDefaultLabel() + "\"");
				
				continue;
			}
			
			if(el.hasClass(CSS_SELECTOR_TABLE_CLASS)){
				
				for(Element row : el.select(CSS_SELECTOR_TR)){
					
					Element firstCol = row.children().first();
						
					Element header = firstCol.select(CSS_SELECTOR_HIGHLEVELCONCEPT).first();
					if(header != null){
						
						if(header.text().toLowerCase().contains("attributes"))
							continue;
						
						secondLevelConcept = OF4OSMConceptFactory.createHighLevelConcept(header.text() + firstLevelConcept.getDefaultLabel());
						secondLevelConcept.addParent((IHighLevelConceptParent) firstLevelConcept);
						of4osm.addConcept(secondLevelConcept);
						
						LOGGER.log(Level.INFO, "Adding HighLevelConcept \"" + secondLevelConcept.getDefaultLabel() + "\"");			
					
					} else {
						
						Element keyCol = row.select(CSS_SELECTOR_KEY).first();
						
						if(key.getValue().equals("Aerialway") 
								|| (key.getValue().equals("Places") && keyCol != null && keyCol.text().equals("place"))
								|| (keyCol != null && keyCol.text().equals(key.getValue()))){
						
							Element valueCol = row.select(CSS_SELECTOR_TAG).first();
							
							if(valueCol != null && !valueCol.text().equals("user defined")){
								
							value = OF4OSMTagIdentifier.identifyValue(valueCol.text());
								
								IOSMTag osmTag = OF4OSMTagIdentifier.identifyTag(key, value);
								
								if(osmTag instanceof OSMSimpleCategoryTag){
									
									tag = (OSMSimpleCategoryTag) osmTag;
									
									keyConcept = OF4OSMConceptFactory.createOSMTagSimpleKeyConcept((IOSMTagSimpleKey) key);
									tagConcept = OF4OSMConceptFactory.createOSMSimpleCategoryTagConcept(tag, (IOSMStatelessTagConceptParent) keyConcept);
									
									if(secondLevelConcept != null){
										tagConcept.addParent((IOSMStatelessTagConceptParent) secondLevelConcept);
									}
									
									of4osm.addConcept(keyConcept);
									of4osm.addConcept(tagConcept);
									
									LOGGER.log(Level.INFO, "Adding IOSMCategoryTagConcept \"" + tagConcept.getDefaultLabel() + "\"");
								}
							}
						}
					}
				}
			}
		}
		
		final long t1 = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "Adding tags from the OSM Wiki Map Features Web page to OF4OSM done (" + DurationFormatUtils.formatDurationHMS(t1 - t0) + ").");
		
		LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagKeyConcept instances: " + of4osm.getOSMTagSimpleKeyConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IHighLevelConcept instances: " + of4osm.getHighLevelConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagConcept instances: " + of4osm.getOSMSimpleCategoryTagConcepts().size());
		
	}
	
}
