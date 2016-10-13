package lig.steamer.of4osm;

import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.io.OF4OSMFolksoReaderOSMAPI;
import lig.steamer.of4osm.io.OF4OSMOntoReaderOSMWiki;
import lig.steamer.of4osm.io.OF4OSMOntoWriterOWL;
import lig.steamer.of4osm.parse.OF4OSMFolkso2OntoParser;
import lig.steamer.of4osm.ws.osmapi.OSMAPIRequest;
import lig.steamer.of4osm.ws.osmapi.OSMAPIResponse;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIRequest;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIResponse;
import lig.steamer.of4osm.ws.osmwiki.OSMMediaWikiAPIClient;
import lig.steamer.of4osm.ws.xapi.OverpassXAPIClient;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

    	final long t1 = System.currentTimeMillis();
    	
        IOF4OSMOntology of4osm = new OF4OSMOntology();
        
        // Initialize OF4OSM with Map Features page of the OSM wiki.
        MediaWikiAPIRequest osmWikiReq = new MediaWikiAPIRequest("parse", "Map_Features", "text", "json");
		OSMMediaWikiAPIClient osmWikiClient = new OSMMediaWikiAPIClient();
		MediaWikiAPIResponse osmWikiResponse = osmWikiClient.send(osmWikiReq);
		of4osm = OF4OSMOntoReaderOSMWiki.read(osmWikiResponse, of4osm);
		
		final long t2 = System.currentTimeMillis();
		System.out.println("Initializing time: " + (t2 - t1));
		
		// Populate OF4OSM with OSM tags associated with Grenoble located objects.
//         OSMAPIRequest osmApiReq = new OSMAPIRequest("5.677606", "45.15414", "5.753118", "45.214077"); 
		// Secteur 6
        OSMAPIRequest osmApiReq = new OSMAPIRequest("5.720359", "45.15414", "5.741375", "45.170532"); 
        OverpassXAPIClient osmApiClient = new OverpassXAPIClient();
        OSMAPIResponse osmApiResp = osmApiClient.send(osmApiReq);
        IOF4OSMFolksonomy folkso = OF4OSMFolksoReaderOSMAPI.read(osmApiResp);
        
        final long t3 = System.currentTimeMillis();
		System.out.println("Folksonomy parsing time: " + (t3 - t2));
        
//        Folkso2CSVWriter.write(folkso);
        of4osm = OF4OSMFolkso2OntoParser.addConceptsFromFolkso(of4osm, folkso);
        
        final long t4 = System.currentTimeMillis();
		System.out.println("Folksonomy parsing time: " + (t4 - t3));
		
        // Write OF4OSM to file in OWL format.
        OF4OSMOntoWriterOWL ontoWriter = new OF4OSMOntoWriterOWL();
        ontoWriter.write(of4osm);
        
        final long t5 = System.currentTimeMillis();
		System.out.println("Execution time: " + (t5 - t4));

    }

}
