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
public final class OSMAPI2FolksoParser {

	private static final Logger LOGGER = Logger.getLogger(OSMAPI2FolksoParser.class.getName());
	
    public static IOF4OSMFolksonomy parse(OSMAPIResponse resp) {

    	LOGGER.log(Level.INFO, "Parsing the OSM API Response...");
    	
    	OF4OSMFolksonomy folkso = new OF4OSMFolksonomy();
    	
        for (OSMAPIElement element : resp.getElements()) {
            if (element.getTags() != null) {
            	Set<IOSMTag> osmTags = new HashSet<>();
                for (OSMAPITag tag : element.getTags()) {
                    IOSMTagKey key = stringToKey(tag.getK(), "");
                    IOSMTagValue value = stringToValue(tag.getV());
                    IOSMTag osmTag = typeTags(key, value);

                    osmTags.add(osmTag);
                }
                folkso.addTags(element.getId(), osmTags);
            }
        }
        
        LOGGER.log(Level.INFO, "Parsing the OSM API Response is done.");
        
        return folkso;
    }
    
    

}
