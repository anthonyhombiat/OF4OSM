package lig.steamer.of4osm.io;

import static lig.steamer.of4osm.util.OF4OSMTagIdentifier.identifyKey;
import static lig.steamer.of4osm.util.OF4OSMTagIdentifier.identifyValue;
import static lig.steamer.of4osm.util.OF4OSMTagIdentifier.identifyTag;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.core.folkso.IOF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;
import lig.steamer.of4osm.ws.overpass.OverpassAPIElement;
import lig.steamer.of4osm.ws.overpass.OverpassAPIResponse;

/**
 *
 * @author amehiris
 */
public final class OF4OSMFolksoReaderOverpassAPI {
	
	private static final Logger LOGGER = Logger.getLogger(OF4OSMFolksoReaderOverpassAPI.class.getName());

    public static IOF4OSMFolksonomy read(OverpassAPIResponse resp) {

    	LOGGER.log(Level.INFO, "Reading folksonomy from the Overpass API...");
    	
    	OF4OSMFolksonomy folkso = new OF4OSMFolksonomy();
    	
    	List<OverpassAPIElement> elements = resp.getElements();

        for (OverpassAPIElement element : elements) {

            Map<String, String> mapTags = element.getTags();
            Set<IOSMTag> osmTags = new HashSet<>();
            for (Entry<String, String> tag : mapTags.entrySet()) {
            	IOSMTagKey key = identifyKey(tag.getKey(), "");
                IOSMTagValue value = identifyValue(tag.getValue());
                IOSMTag osmTag = identifyTag(key, value);
                osmTags.add(osmTag);
            }
            folkso.addTagsByElement(element.getId(), osmTags);
        }
        
        LOGGER.log(Level.INFO, "Reading folksonomy from the Overpass API done.");
        
        return folkso;
    }
}
