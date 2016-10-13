package lig.steamer.of4osm.ws.osmapi;

import junit.framework.TestCase;

/**
 *
 * @author amehiris
 */
public class OSMAPIClientTest extends TestCase {

	public OSMAPIClientTest(String name) {
		super(name);
	}
	
	public void testSend() {
        
		// Halles St Claire, Grenoble
        OSMAPIRequest req = new OSMAPIRequest("5.7293608785", "45.1897415202", "5.7322975993", "45.1917694442");
        OSMAPIClient client = new OSMAPIClient();
        OSMAPIResponse resp = client.send(req);
        
        assertNotNull(resp);
    }
}
