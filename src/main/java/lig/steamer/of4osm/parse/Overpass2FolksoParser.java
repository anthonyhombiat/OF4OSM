/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.parse;

import static lig.steamer.of4osm.util.FolksoParsingTool.stringToKey;
import static lig.steamer.of4osm.util.FolksoParsingTool.stringToValue;
import static lig.steamer.of4osm.util.FolksoParsingTool.typeTags;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.IOF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;
import lig.steamer.of4osm.ws.overpass.OverpassElement;
import lig.steamer.of4osm.ws.overpass.OverpassResponse;

/**
 *
 * @author amehiris
 */
public final class Overpass2FolksoParser {
	
	private static final Logger LOGGER = Logger.getLogger(Overpass2FolksoParser.class.getName());

    public static IOF4OSMFolksonomy parse(OverpassResponse resp) {

    	LOGGER.log(Level.INFO, "Parsing the Overpass Response...");
    	
    	OF4OSMFolksonomy folkso = new OF4OSMFolksonomy();
    	
    	List<OverpassElement> elements = resp.getElements();

        for (OverpassElement element : elements) {

            Map<String, String> mapTags = element.getTags();
            Set<IOSMTag> osmTags = new HashSet<>();
            for (Entry<String, String> tag : mapTags.entrySet()) {
            	IOSMTagKey key = stringToKey(tag.getKey(), "");
                IOSMTagValue value = stringToValue(tag.getValue());
                IOSMTag osmTag = typeTags(key, value);
                osmTags.add(osmTag);
            }
            folkso.addTags(element.getId(), osmTags);
        }
        
        LOGGER.log(Level.INFO, "Parsing the Overpass Response is done.");
        
        return folkso;
    }
}
