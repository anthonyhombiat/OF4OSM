package lig.steamer.of4osm.ws.overpass;

import junit.framework.TestCase;

/**
*
* @author amehiris
*/
public class OverPassClientTest extends TestCase {

	public OverPassClientTest(String name) {
		super(name);
	}

	public void testSend() {
		
		String bBoxGrenoble = "(45.154005,5.678004,45.214326,5.753081)";
        
        OverPassRequest req = new OverPassRequest(bBoxGrenoble, "node", "amenity", "pharmacy");
        OverPassClient client = new OverPassClient();
        OverPassResponse resp = client.send(req);
        
        assertNotNull(resp);
	}

}
