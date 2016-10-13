package lig.steamer.of4osm.io;

import static lig.steamer.of4osm.util.OF4OSMTagIdentifier.identifyKey;
import static lig.steamer.of4osm.util.OF4OSMTagIdentifier.identifyValue;
import static lig.steamer.of4osm.util.OF4OSMTagIdentifier.identifyTag;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.IOF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;
import lig.steamer.of4osm.ws.osmapi.OSMAPIElement;
import lig.steamer.of4osm.ws.osmapi.OSMAPIResponse;
import lig.steamer.of4osm.ws.osmapi.OSMAPITag;

/**
 *
 * @author amehiris
 */
public final class OF4OSMFolksoReaderOSMAPI {

	private static final Logger LOGGER = Logger.getLogger(OF4OSMFolksoReaderOSMAPI.class.getName());
	
    public static IOF4OSMFolksonomy read(OSMAPIResponse resp) {

    	LOGGER.log(Level.INFO, "Reading folksonomy from the OSM API...");
    	
    	OF4OSMFolksonomy folkso = new OF4OSMFolksonomy();
    	
        for (OSMAPIElement element : resp.getElements()) {
            if (element.getTags() != null) {
            	Set<IOSMTag> osmTags = new HashSet<>();
                for (OSMAPITag tag : element.getTags()) {
                    IOSMTagKey key = identifyKey(tag.getK(), "");
                    IOSMTagValue value = identifyValue(tag.getV());
                    IOSMTag osmTag = identifyTag(key, value);

                    osmTags.add(osmTag);
                }
                folkso.addTags(element.getId(), osmTags);
            }
        }
        
        LOGGER.log(Level.INFO, "Reading folksonomy from the OSM API done.");
        
        return folkso;
    }
    
    

}
