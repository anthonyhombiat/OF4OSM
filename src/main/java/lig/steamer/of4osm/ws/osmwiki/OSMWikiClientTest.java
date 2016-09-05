package lig.steamer.of4osm.ws.osmwiki;

import java.util.List;


public class OSMWikiClientTest {

	public static void main(String[] args) {
		
		final String PROPERTY_TAGS = "Additional properties";
		
		OSMWikiRequest sectionsReq = new OSMWikiRequest("parse", "Map_Features", "sections", "json");
		OSMWikiClient client = new OSMWikiClient();
		
		System.out.println("SENDING REQUEST...");
		
		OSMWikiResponse sectionsResponse = client.send(sectionsReq);
		
		System.out.println("RESPONSE RECIEVED.");
		
		List<OSMWikiResponseParseSection> sections = sectionsResponse.getParse().getSections();
		for(OSMWikiResponseParseSection section : sections){
			
			if(section.getLine().equals(PROPERTY_TAGS)){
				return;
			}
			
			if(section.getToclevel() > 1){
				
				for(int i=2;i<section.getToclevel();i++){
					System.out.print("\t");
				}
				
				System.out.println(section.getLine());
			}
			
		}
	}

}
