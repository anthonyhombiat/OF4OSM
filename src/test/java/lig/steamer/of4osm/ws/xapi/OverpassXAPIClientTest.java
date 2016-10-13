package lig.steamer.of4osm.ws.xapi;

import junit.framework.TestCase;
import lig.steamer.of4osm.ws.osmapi.OSMAPIRequest;
import lig.steamer.of4osm.ws.osmapi.OSMAPIResponse;

public class OverpassXAPIClientTest extends TestCase {

	public OverpassXAPIClientTest(String name) {
		super(name);
	}
	
	public void testSend(){
		
		// Halles St Claire, Grenoble
        OSMAPIRequest req = new OSMAPIRequest("5.7293608785", "45.1897415202", "5.7322975993", "45.1917694442");
		OverpassXAPIClient client = new OverpassXAPIClient();
		OSMAPIResponse resp = client.send(req);
		
		assertNotNull(resp);
		
	}

}
