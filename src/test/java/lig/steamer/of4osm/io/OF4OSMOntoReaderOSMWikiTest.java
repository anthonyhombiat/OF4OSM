package lig.steamer.of4osm.io;

import junit.framework.TestCase;
import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.io.OF4OSMOntoReaderOSMWiki;
import lig.steamer.of4osm.ws.osmwiki.OSMMediaWikiAPIClient;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIRequest;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIResponse;

public class OF4OSMOntoReaderOSMWikiTest extends TestCase {

	public OF4OSMOntoReaderOSMWikiTest(String name) {
		super(name);
	}
	
	public void testRead(){
		
		MediaWikiAPIRequest req = new MediaWikiAPIRequest("parse", "Map_Features", "text", "json");
		OSMMediaWikiAPIClient client = new OSMMediaWikiAPIClient();
		MediaWikiAPIResponse response = client.send(req);
		
		IOF4OSMOntology of4osm = OF4OSMOntoReaderOSMWiki.read(response, new OF4OSMOntology());
		
		assertNotNull(of4osm);
	}

}