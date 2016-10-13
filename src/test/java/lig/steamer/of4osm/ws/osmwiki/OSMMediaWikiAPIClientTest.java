package lig.steamer.of4osm.ws.osmwiki;

import junit.framework.TestCase;


public class OSMMediaWikiAPIClientTest extends TestCase {
	
	public OSMMediaWikiAPIClientTest(String name){
		super(name);
	}

	public static void testSend() {
		
		MediaWikiAPIRequest req = new MediaWikiAPIRequest("parse", "Map_Features", "text", "json");
		OSMMediaWikiAPIClient client = new OSMMediaWikiAPIClient();
		MediaWikiAPIResponse response = client.send(req);
		
		assertNotNull(response);
		
	}
}
