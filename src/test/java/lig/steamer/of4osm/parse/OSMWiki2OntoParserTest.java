package lig.steamer.of4osm.parse;

import junit.framework.TestCase;
import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.ws.osmwiki.OSMWikiClient;
import lig.steamer.of4osm.ws.osmwiki.OSMWikiRequest;
import lig.steamer.of4osm.ws.osmwiki.OSMWikiResponse;

public class OSMWiki2OntoParserTest extends TestCase {

	public OSMWiki2OntoParserTest(String name) {
		super(name);
	}
	
	public void testParse(){
		
		OSMWikiRequest req = new OSMWikiRequest("parse", "Map_Features", "text", "json");
		OSMWikiClient client = new OSMWikiClient();
		OSMWikiResponse response = client.send(req);
		
		IOF4OSMOntology of4osm = OSMWiki2OntoParser.parse(response, new OF4OSMOntology());
		
		assertNotNull(of4osm);
	}

}
