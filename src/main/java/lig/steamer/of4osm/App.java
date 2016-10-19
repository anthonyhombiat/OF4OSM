package lig.steamer.of4osm;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.time.DurationFormatUtils;

import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.io.OF4OSMFolksoReaderOSMAPI;
import lig.steamer.of4osm.io.OF4OSMOntoReaderOSMMediaWikiAPI;
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

	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	
    public static void main(String[] args) {
    	
    	final long t0 = System.currentTimeMillis();
    	
        IOF4OSMOntology of4osm = new OF4OSMOntology();
        
        // Initialize OF4OSM with Map Features page of the OSM wiki.
        MediaWikiAPIRequest osmWikiReq = new MediaWikiAPIRequest("parse", "Map_Features", "text", "json");
		OSMMediaWikiAPIClient osmWikiClient = new OSMMediaWikiAPIClient();
		MediaWikiAPIResponse osmWikiResponse = osmWikiClient.send(osmWikiReq);
		
		final long t1 = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "OSM Wiki data retrieving time: " + DurationFormatUtils.formatDurationHMS(t1 - t0));
		
		of4osm = OF4OSMOntoReaderOSMMediaWikiAPI.read(osmWikiResponse, of4osm);
		
		final long t2 = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "Ontology initializing time: " + DurationFormatUtils.formatDurationHMS(t2 - t1));
		
		// Populate OF4OSM with OSM tags associated with Grenoble located objects.
         OSMAPIRequest osmApiReq = new OSMAPIRequest("5.677606", "45.15414", "5.753118", "45.214077"); 
		// Secteur 6
//        OSMAPIRequest osmApiReq = new OSMAPIRequest("5.720359", "45.15414", "5.741375", "45.170532"); 
        OverpassXAPIClient osmApiClient = new OverpassXAPIClient();
        OSMAPIResponse osmApiResp = osmApiClient.send(osmApiReq);
        
        final long t3 = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "OSM API Data retrieving time: " + DurationFormatUtils.formatDurationHMS(t3 - t2));
        
        IOF4OSMFolksonomy folkso = OF4OSMFolksoReaderOSMAPI.read(osmApiResp);
        
        final long t4 = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "Folksonomy reading time: " + DurationFormatUtils.formatDurationHMS(t4 - t3));
        
//        Folkso2CSVWriter.write(folkso);
        of4osm = OF4OSMFolkso2OntoParser.addConceptsFromFolkso(of4osm, folkso);
        
        final long t5 = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "Folksonomy to Ontology parsing time: " + DurationFormatUtils.formatDurationHMS(t5 - t4));
		
        // Write OF4OSM to file in OWL format.
        OF4OSMOntoWriterOWL ontoWriter = new OF4OSMOntoWriterOWL();
        ontoWriter.write(of4osm);
        
        final long t6 = System.currentTimeMillis();
        LOGGER.log(Level.INFO, "OWL file writing time: " + DurationFormatUtils.formatDurationHMS(t6 - t5));
        LOGGER.log(Level.INFO, "Total execution time: " + DurationFormatUtils.formatDurationHMS(t6 - t0));

    }

}
