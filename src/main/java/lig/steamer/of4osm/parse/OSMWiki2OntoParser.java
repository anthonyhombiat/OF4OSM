package lig.steamer.of4osm.parse;

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
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.impl.HighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagKeyConcept;
import lig.steamer.of4osm.util.FolksoLabelExtractor;
import lig.steamer.of4osm.util.FolksoParsingTool;
import lig.steamer.of4osm.util.OF4OSMStringUtil;
import lig.steamer.of4osm.ws.osmwiki.OSMWikiResponse;
import lig.steamer.of4osm.ws.osmwiki.OSMWikiResponseParseText;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public final class OSMWiki2OntoParser {
	
	private static final Logger LOGGER = Logger.getLogger(OSMWiki2OntoParser.class.getName());
	
	public static final String CATEGORY_TAGS_ID = "Primary_features";
	
	public static IOF4OSMOntology parse(OSMWikiResponse response, IOF4OSMOntology of4osm){
		
		LOGGER.log(Level.INFO, "Adding Map Features tags to OF4OSM...");
		
		OSMWikiResponseParseText text = response.getParse().getText();
		
		Document htmlDoc = Jsoup.parse(text.getAll());
		
		IOSMTagKey key;
		IOSMTagValue value;
		IOSMSimpleCategoryTag tag;
		IOSMCategoryTagKeyConcept keyConcept;
		IHighLevelConcept highLevelConcept;
		IOSMCategoryTagConcept tagConcept;
		
		int nbKeys = 0;
		int nbHighLevelConcepts = 0;
		int nbValues = 0;
		
		Element primaryFeaturesHeader = htmlDoc.getElementById(CATEGORY_TAGS_ID).parent();
		int index = primaryFeaturesHeader.siblingIndex();
		List<Element> siblings = primaryFeaturesHeader.siblingElements();
		
		index++;
		
		key = new OSMTagSimpleKey(OF4OSMStringUtil.normalize(siblings.get(index).text()),"");
		keyConcept = new OSMCategoryTagKeyConcept(key.getValue(), key);
		LOGGER.log(Level.INFO, "Adding IOSMCategoryTagKeyConcept \"" + keyConcept.getDefaultLabel() + "\"");
		nbKeys++;
		
		for(Element el : siblings){
			
			if(el.tagName().equals("h2")) break;
			
			if(el.tagName().equals("h3")){
			
				key = new OSMTagSimpleKey(OF4OSMStringUtil.normalize(el.text()), "");
				keyConcept = new OSMCategoryTagKeyConcept(key.getValue(), key);
				of4osm.addConcept(keyConcept);
				
				LOGGER.log(Level.INFO, "Adding IOSMCategoryTagKeyConcept \"" + keyConcept.getDefaultLabel() + "\"");
				
				nbKeys++;
				
			}
			
			if(el.hasClass("wikitable")){
				
				List<Element> rows = el.select("tr");
				for(Element row : rows){
					
					Element firstCol = row.children().first();
						
					// is highLevelConcept row
					Element header = firstCol.select("h4 span.mw-headline").first();
					if(header != null){
						
						highLevelConcept = new HighLevelConcept(OF4OSMStringUtil.normalize(header.text()));
						of4osm.addConcept(highLevelConcept);
						
						LOGGER.log(Level.INFO, "Adding HighLevelConcept \"" + highLevelConcept.getDefaultLabel() + "\"");
						
						nbHighLevelConcepts++;					
					} else {
						
						Element valueCol = row.select("td a[title^='Tag:']").first();
						if(valueCol != null){
							
							value = FolksoParsingTool.stringToValue(OF4OSMStringUtil.normalize(valueCol.text()));
							
							if(FolksoParsingTool.typeTags(key, value) instanceof OSMSimpleCategoryTag){
								tag = (OSMSimpleCategoryTag) FolksoParsingTool.typeTags(key, value);
								String label = FolksoLabelExtractor.getLabelFromIOSMSimpleCategoryTag(tag);
								
								tagConcept = new OSMCategoryTagConcept(label, tag, keyConcept);
								of4osm.addConcept(tagConcept);
								
								LOGGER.log(Level.INFO, "Adding IOSMCategoryTagConcept \"" + tagConcept.getDefaultLabel() + "\"");
								
								nbValues++;
							}
						}
					}
				}
			}
		}
		
		System.out.println("Nb of IHighLevelConcept instances: " + nbHighLevelConcepts);
		System.out.println("Nb of IOSMCategoryTagKeyConcept instances: " + nbKeys);
		System.out.println("Nb of IOSMCategoryTagConcept instances: " + nbValues);
		
		LOGGER.log(Level.INFO, "Adding Map Features tags to OF4OSM done.");
		
		return of4osm;
	}
	
}
