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
        
        OSMAPIRequest req = new OSMAPIRequest("5.712204", "45.178649", "5.727654", "45.189538");
        OSMAPIClient client = new OSMAPIClient();
        OSMAPIResponse resp = client.send(req);
        
        assertNotNull(resp);
    }
}
