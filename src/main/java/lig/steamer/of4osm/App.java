package lig.steamer.of4osm;

import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.core.folkso.IOF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.key.impl.LifecycleState;
import lig.steamer.of4osm.core.onto.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.io.OF4OSMFolksoReaderOSMAPI;
import lig.steamer.of4osm.io.OF4OSMOntoReaderLifecycleStates;
import lig.steamer.of4osm.io.OF4OSMOntoReaderOSMMediaWikiAPI;
import lig.steamer.of4osm.io.OF4OSMOntoWriterOWL;
import lig.steamer.of4osm.parse.OF4OSMFolkso2OntoParser;
import lig.steamer.of4osm.ws.osmapi.OSMAPIRequest;
import lig.steamer.of4osm.ws.osmapi.OSMAPIResponse;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIRequest;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIResponse;
import lig.steamer.of4osm.ws.osmwiki.OSMMediaWikiAPIClient;
import lig.steamer.of4osm.ws.xapi.OverpassXAPIClient;

import org.apache.commons.lang3.time.DurationFormatUtils;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class App {

	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	
    public static void main(String[] args) {
    	
    	final long t0 = System.currentTimeMillis();
    	
        IOF4OSMOntology of4osm = new OF4OSMOntology();
        
        // Initialize OF4OSM with Map Features page of the OSM wiki.
        MediaWikiAPIRequest osmWikiReq = new MediaWikiAPIRequest("parse", "Map_Features", "text", "json");
		OSMMediaWikiAPIClient osmWikiClient = new OSMMediaWikiAPIClient();
		MediaWikiAPIResponse osmWikiResponse = osmWikiClient.send(osmWikiReq);
		
		OF4OSMOntoReaderLifecycleStates.read(LifecycleState.values(), of4osm);
		OF4OSMOntoReaderOSMMediaWikiAPI.read(osmWikiResponse, of4osm);
		
		// Populate OF4OSM with OSM tags associated with Grenoble located objects.
         OSMAPIRequest osmApiReq = new OSMAPIRequest("5.677606", "45.15414", "5.753118", "45.214077"); 
		// Secteur 6
//        OSMAPIRequest osmApiReq = new OSMAPIRequest("5.720359", "45.15414", "5.741375", "45.170532"); 
        OverpassXAPIClient osmApiClient = new OverpassXAPIClient();
        OSMAPIResponse osmApiResp = osmApiClient.send(osmApiReq);
        
        IOF4OSMFolksonomy folkso = OF4OSMFolksoReaderOSMAPI.read(osmApiResp);
        
//        Folkso2CSVWriter.write(folkso);
        OF4OSMFolkso2OntoParser.addConceptsFromFolkso(of4osm, folkso);
		
        // Write OF4OSM to file in OWL format.
        OF4OSMOntoWriterOWL ontoWriter = new OF4OSMOntoWriterOWL();
        ontoWriter.write(of4osm);
        
        final long t6 = System.currentTimeMillis();
        LOGGER.log(Level.INFO, "Total execution time: " + DurationFormatUtils.formatDurationHMS(t6 - t0));

    }

}
