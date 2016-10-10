package lig.steamer.of4osm.ws.osmwiki;

import junit.framework.TestCase;


public class OSMWikiClientTest extends TestCase {
	
	public OSMWikiClientTest(String name){
		super(name);
	}

	public static void testSend() {
		
		OSMWikiRequest req = new OSMWikiRequest("parse", "Map_Features", "text", "json");
		OSMWikiClient client = new OSMWikiClient();
		OSMWikiResponse response = client.send(req);
		
		assertNotNull(response);
		
	}
}
