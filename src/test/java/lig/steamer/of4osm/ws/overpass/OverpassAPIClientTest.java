package lig.steamer.of4osm.ws.overpass;

import junit.framework.TestCase;

/**
*
* @author amehiris
*/
public class OverpassAPIClientTest extends TestCase {

	public OverpassAPIClientTest(String name) {
		super(name);
	}

	public void testSend() {
		
        OverpassAPIRequest req = new OverpassAPIRequest(
        		"45.1897415202,5.7293608785,45.1917694442,5.7322975993", // Halles St Claire, Grenoble
        		"node", // element type (node/way/relation)
        		"amenity", // key
        		"pharmacy"); // value
        OverpassAPIClient client = new OverpassAPIClient();
        OverpassAPIResponse resp = client.send(req);
        
        assertNotNull(resp);
	}

}
