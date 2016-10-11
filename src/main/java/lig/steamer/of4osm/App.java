package lig.steamer.of4osm;

import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.io.OF4OSMOntoWriterOWL;
import lig.steamer.of4osm.io.OF4OSMFolksoReaderOSMAPI;
import lig.steamer.of4osm.io.OF4OSMOntoReaderOSMWiki;
import lig.steamer.of4osm.parse.OF4OSMFolkso2OntoParser;
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
		of4osm = OF4OSMOntoReaderOSMWiki.read(osmWikiResponse, of4osm);
		
		// Populate OF4OSM with OSM tags associated with Grenoble located objects.
        OSMAPIRequest osmApiReq = new OSMAPIRequest("5.677606", "45.15414", "5.753118", "45.214077"); 
        OSMAPIClient osmApiClient = new OSMAPIClient();
        OSMAPIResponse osmApiResp = osmApiClient.send(osmApiReq);
        IOF4OSMFolksonomy folkso = OF4OSMFolksoReaderOSMAPI.read(osmApiResp);
//        Folkso2CSVWriter.write(folkso);
        of4osm = OF4OSMFolkso2OntoParser.addConceptsFromFolkso(of4osm, folkso);
        
        // Write OF4OSM to file in OWL format.
        OF4OSMOntoWriterOWL ontoWriter = new OF4OSMOntoWriterOWL();
        ontoWriter.write(of4osm);

    }

}
