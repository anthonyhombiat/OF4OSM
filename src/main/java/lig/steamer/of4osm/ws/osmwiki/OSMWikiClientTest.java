package lig.steamer.of4osm.ws.osmwiki;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class OSMWikiClientTest {

	public static void main(String[] args) {
		
		final String CATEGORY_TAGS_ID = "Primary_features";
		
		OSMWikiRequest sectionsReq = new OSMWikiRequest("parse", "Map_Features", "text", "json");
		OSMWikiClient client = new OSMWikiClient();
		
		System.out.println("SENDING REQUEST TO...");
		
		OSMWikiResponse response = client.send(sectionsReq);
		
		System.out.println("RESPONSE RECIEVED.");
		
		OSMWikiResponseParseText text = response.getParse().getText();
		
		Document htmlDoc = Jsoup.parse(text.getAll());
		
		String key = "";
		String highLevelConcept = "";
		String value = "";
		
		Element primaryFeaturesHeader = htmlDoc.getElementById(CATEGORY_TAGS_ID).parent();
		List<Element> siblings = primaryFeaturesHeader.siblingElements();
		
		for(Element el : siblings){
			
			if(el.tagName().equals("h2")) break;
			
			if(el.tagName().equals("h3")){
			
				key = el.text();
				System.out.println(key);
				
			}
			
			if(el.hasClass("wikitable")){
				
				List<Element> rows = el.select("tr");
				for(Element row : rows){
					
					Element firstCol = row.children().first();
						
					// is highLevelConcept row
					Element header = firstCol.select("h4 span.mw-headline").first();
					if(header != null){
						highLevelConcept = header.text();
						System.out.println("\t" + highLevelConcept);
					} else {
						
						Element valueCol = row.select("td a[title^='Tag:']").first();
						if(valueCol != null){
							value = valueCol.text();
							System.out.println("\t\t" + value);
						}
					}
				}
			}
		}
	}
}
