package lig.steamer.of4osm;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.time.DurationFormatUtils;

import lig.steamer.of4osm.core.folkso.IOF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.key.impl.LifecycleState;
import lig.steamer.of4osm.core.onto.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.tools.io.OF4OSMFolksoReaderOSMAPI;
import lig.steamer.of4osm.tools.io.OF4OSMOntoReaderLifecycleStates;
import lig.steamer.of4osm.tools.io.OF4OSMOntoReaderOSMMediaWikiAPI;
import lig.steamer.of4osm.tools.io.OF4OSMOntoWriterOWL;
import lig.steamer.of4osm.tools.parse.OF4OSMFolkso2OntoParser;
import lig.steamer.of4osm.ws.osmapi.OSMAPIRequest;
import lig.steamer.of4osm.ws.osmapi.OSMAPIResponse;
import lig.steamer.of4osm.ws.osmwiki.MediaWikiAPIResponse;
import lig.steamer.of4osm.ws.osmwiki.OSMMediaWikiAPIClient;
import lig.steamer.of4osm.ws.osmwiki.OSMMediaWikiAPIRequest;
import lig.steamer.of4osm.ws.xapi.OverpassXAPIClient;

/**
 * 
 * @author Anthony Hombiat
 */
public class App {

	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	
    public static void main(String[] args) {
    	
    	// Grenoble : 5.677606 45.15414 5.753118 45.214077
		// Secteur 1 : 5.715152 45.180363 5.743199 45.205143 
		// Secteur 6 : 5.720359 45.15414 5.741375 45.170532 
        // Tulle : 1.722785 45.239216 1.809914 45.297787
		// Lyon : 4.771813 45.707363 4.898377 45.808266
        // Paris : 2.224122 48.815575 2.46976 48.902157
    	
    	String[] bbox = new String[4];
    	if(args.length == 1) {
	    	if(args[0].matches("^\\d+\\.\\d+ \\d+\\.\\d+ \\d+\\.\\d+ \\d+\\.\\d+$")){
	    	bbox = args[0].split(" ");
	    	} else {
	    		LOGGER.log(Level.INFO, "The BBOX must be in the format \"decimal decimal decimal decimal\".");
	    		System.exit(0);
	    	}
    	} else {
    		LOGGER.log(Level.INFO, "Missing first argument (required).");
	    	System.exit(0);
    	}
    	
    	final long t0 = System.currentTimeMillis();
    	
        IOF4OSMOntology of4osm = new OF4OSMOntology();
        
        // Initialize OF4OSM with Map Features page of the OSM wiki.
        OSMMediaWikiAPIRequest osmWikiReq = new OSMMediaWikiAPIRequest();
		OSMMediaWikiAPIClient osmWikiClient = new OSMMediaWikiAPIClient();
		MediaWikiAPIResponse osmWikiResponse = osmWikiClient.send(osmWikiReq);
		
		OF4OSMOntoReaderLifecycleStates.read(LifecycleState.values(), of4osm);
		OF4OSMOntoReaderOSMMediaWikiAPI.read(osmWikiResponse, of4osm);
		
		// Populate OF4OSM with OSM tags associated with objects within the given bbox
		OSMAPIRequest osmApiReq = new OSMAPIRequest(
				Double.valueOf(bbox[0]),
				Double.valueOf(bbox[1]),
				Double.valueOf(bbox[2]),
				Double.valueOf(bbox[3]));
      
        OverpassXAPIClient osmApiClient = new OverpassXAPIClient();
        OSMAPIResponse osmApiResp = osmApiClient.send(osmApiReq);
        
        IOF4OSMFolksonomy folkso = OF4OSMFolksoReaderOSMAPI.read(osmApiResp);
        
//        OF4OSMFolksoWriterCSV.write(folkso);
        OF4OSMFolkso2OntoParser parser = new OF4OSMFolkso2OntoParser();
        parser.addConceptsFromFolkso(of4osm, folkso);
		
        // Write OF4OSM to file in OWL format.
        OF4OSMOntoWriterOWL ontoWriter = new OF4OSMOntoWriterOWL();
        ontoWriter.write(of4osm);
        
        final long t6 = System.currentTimeMillis();
        LOGGER.log(Level.INFO, "Total execution time: " + DurationFormatUtils.formatDurationHMS(t6 - t0));
        
        LOGGER.log(Level.INFO, "Nb of tags identified in the folksonomy: " + folkso.getNbOfTags());
        LOGGER.log(Level.INFO, "Nb of highLevelConcepts in OF4OSM: " + of4osm.getHighLevelConcepts().size());
        LOGGER.log(Level.INFO, "Nb of keyConcepts in OF4OSM: " + of4osm.getOSMTagSimpleKeyConcepts().size());
        LOGGER.log(Level.INFO, "Nb of tagConcepts in OF4OSM: " + of4osm.getOSMSimpleCategoryTagConcepts().size());
        LOGGER.log(Level.INFO, "Nb of tagcombinationsConcepts in OF4OSM: " + of4osm.getOSMTagCombinationConcepts().size());

    }

}