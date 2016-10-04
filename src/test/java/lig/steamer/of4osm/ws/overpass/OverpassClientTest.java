package lig.steamer.of4osm.ws.overpass;

import junit.framework.TestCase;

/**
*
* @author amehiris
*/
public class OverpassClientTest extends TestCase {

	public OverpassClientTest(String name) {
		super(name);
	}

	public void testSend() {
		
		String bBoxGrenoble = "(45.154005,5.678004,45.214326,5.753081)";
        
        OverpassRequest req = new OverpassRequest(bBoxGrenoble, "node", "amenity", "pharmacy");
        OverpassClient client = new OverpassClient();
        OverpassResponse resp = client.send(req);
        
        assertNotNull(resp);
	}

}
