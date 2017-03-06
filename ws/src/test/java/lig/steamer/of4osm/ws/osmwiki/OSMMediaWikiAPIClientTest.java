package lig.steamer.of4osm.ws.osmwiki;

import junit.framework.TestCase;


public class OSMMediaWikiAPIClientTest extends TestCase {
	
	public OSMMediaWikiAPIClientTest(String name){
		super(name);
	}

	public static void testSend() {
		
		final MediaWikiAPIRequest req = new MediaWikiAPIRequest("parse", "Map_Features", "text", "json");
		final OSMMediaWikiAPIClient client = new OSMMediaWikiAPIClient();
		final MediaWikiAPIResponse response = client.send(req);
		
		assertNotNull(response);
		
	}
}
