package lig.steamer.of4osm.tools.io;

import static lig.steamer.of4osm.tools.utils.OF4OSMTagIdentifier.identifyKey;
import static lig.steamer.of4osm.tools.utils.OF4OSMTagIdentifier.identifyTag;
import static lig.steamer.of4osm.tools.utils.OF4OSMTagIdentifier.identifyValue;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.time.DurationFormatUtils;

import lig.steamer.of4osm.core.folkso.IOF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyDateValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMLocalizedKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyDateValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTimeDomainsValuePropertyTag;
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

    	final long t0 = System.currentTimeMillis();
    	LOGGER.log(Level.INFO, "Reading folksonomy from the OSM API...");
    	
    	IOF4OSMFolksonomy folkso = new OF4OSMFolksonomy();
    	
        for (OSMAPIElement element : resp.getElements()) {
            if (element.getTags() != null) {
            	Set<IOSMTag> osmTags = new HashSet<>();
                for (OSMAPITag tag : element.getTags()) {
                    IOSMTagKey key = identifyKey(tag.getK(), "");
                    if(key != null){
	                    IOSMTagValue value = identifyValue(tag.getV());
	                    if(value != null){
		                    IOSMTag osmTag = identifyTag(key, value);
		                    if(osmTag != null) {
			                    osmTags.add(osmTag);
			                    LOGGER.log(Level.INFO, osmTag.toString());
		                    }
	                    }
                    }
                }
                folkso.addTagsByElement(element.getId(), osmTags);
            }
        }
        
        final long t1 = System.currentTimeMillis();
        LOGGER.log(Level.INFO, "Reading folksonomy from the OSM API done (" + DurationFormatUtils.formatDurationHMS(t1 - t0) + ").");
        LOGGER.log(Level.INFO, "Nb of IOSMTags read: " + folkso.getNbOfTags());
        
        LOGGER.log(Level.INFO, "Nb of IOSMSimpleCategoryTags read: " + folkso.getNbOfTagsByType(IOSMSimpleCategoryTag.class));
        LOGGER.log(Level.INFO, "Nb of IOSMStatefulCategoryTags read: " + folkso.getNbOfTagsByType(IOSMStatefulCategoryTag.class));
        LOGGER.log(Level.INFO, "Nb of IOSMMultipleCategoryTags read: " + folkso.getNbOfTagsByType(IOSMMultipleCategoryTag.class));
        
        LOGGER.log(Level.INFO, "Nb of IOSMSimpleKeyStringPropertyTags read: " + folkso.getNbOfTagsByType(IOSMSimpleKeyStringValuePropertyTag.class));
        LOGGER.log(Level.INFO, "Nb of IOSMComplexKeyStringPropertyTags read: " + folkso.getNbOfTagsByType(IOSMComplexKeyStringValuePropertyTag.class));
        LOGGER.log(Level.INFO, "Nb of IOSMLocalizedKeyStringPropertyTags read: " + folkso.getNbOfTagsByType(IOSMLocalizedKeyStringValuePropertyTag.class));
        
        LOGGER.log(Level.INFO, "Nb of IOSMSimpleKeyBooleanPropertyTags read: " + folkso.getNbOfTagsByType(IOSMSimpleKeyBooleanValuePropertyTag.class));
        LOGGER.log(Level.INFO, "Nb of IOSMComplexKeyBooleanPropertyTags read: " + folkso.getNbOfTagsByType(IOSMComplexKeyBooleanValuePropertyTag.class));
        
        LOGGER.log(Level.INFO, "Nb of IOSMSimpleKeyNumericValuePropertyTags read: " + folkso.getNbOfTagsByType(IOSMSimpleKeyNumericValuePropertyTag.class));
        LOGGER.log(Level.INFO, "Nb of IOSMComplexKeyNumericValuePropertyTags read: " + folkso.getNbOfTagsByType(IOSMComplexKeyNumericValuePropertyTag.class));
        
        LOGGER.log(Level.INFO, "Nb of IOSMSimpleKeyDateValuePropertyTags read: " + folkso.getNbOfTagsByType(IOSMSimpleKeyDateValuePropertyTag.class));
        LOGGER.log(Level.INFO, "Nb of IOSMComplexKeyDateValuePropertyTags read: " + folkso.getNbOfTagsByType(IOSMComplexKeyDateValuePropertyTag.class));
        
        LOGGER.log(Level.INFO, "Nb of IOSMTimeDomainsValuePropertyTags read: " + folkso.getNbOfTagsByType(IOSMTimeDomainsValuePropertyTag.class));
        LOGGER.log(Level.INFO, "Nb of IOSMMultipleValuePropertyTag read: " + folkso.getNbOfTagsByType(IOSMMultipleValuePropertyTag.class));
        
        return folkso;
    }
    
}
