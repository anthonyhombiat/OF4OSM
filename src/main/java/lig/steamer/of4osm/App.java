package lig.steamer.of4osm;

import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.io.Onto2OWLWriter;
import lig.steamer.of4osm.parse.Folkso2OntoParser;
import lig.steamer.of4osm.parse.OSMAPI2FolksoParser;
import lig.steamer.of4osm.parse.OSMWiki2OntoParser;
import lig.steamer.of4osm.ws.osmapi.OSMAPIClient;
import lig.steamer.of4osm.ws.osmapi.OSMAPIRequest;
import lig.steamer.of4osm.ws.osmapi.OSMAPIResponse;
import lig.steamer.of4osm.ws.osmwiki.OSMWikiClient;
import lig.steamer.of4osm.ws.osmwiki.OSMWikiRequest;
import lig.steamer.of4osm.ws.osmwiki.OSMWikiResponse;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        IOF4OSMOntology of4osm = new OF4OSMOntology();
        
        // Initialize OF4OSM with Map Features page of the OSM wiki.
        OSMWikiRequest osmWikiReq = new OSMWikiRequest("parse", "Map_Features", "text", "json");
		OSMWikiClient osmWikiClient = new OSMWikiClient();
		OSMWikiResponse osmWikiResponse = osmWikiClient.send(osmWikiReq);
		of4osm = OSMWiki2OntoParser.parse(osmWikiResponse, of4osm);
		
		// Populate OF4OSM with OSM tags associated with Grenoble located objects.
        OSMAPIRequest osmApiReq = new OSMAPIRequest("5.677606", "45.15414", "5.753118", "45.214077"); 
        OSMAPIClient osmApiClient = new OSMAPIClient();
        OSMAPIResponse osmApiResp = osmApiClient.send(osmApiReq);
        IOF4OSMFolksonomy folkso = OSMAPI2FolksoParser.parse(osmApiResp);
//        Folkso2CSVWriter.write(folkso);
        of4osm = Folkso2OntoParser.addConceptsFromFolkso(of4osm, folkso);
        
        // Write OF4OSM to file in OWL format.
        Onto2OWLWriter ontoParser = new Onto2OWLWriter();
        ontoParser.write(of4osm);

    }

}
