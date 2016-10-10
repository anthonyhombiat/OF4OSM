package lig.steamer.of4osm.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.IOF4OSMFolksonomy;
import lig.steamer.of4osm.PropLoader;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyDateValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMLocalizedKeyStringValueTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyDateValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTimeDomainsValuePropertyTag;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author amehiris
 */
public final class Folkso2CSVWriter {
	
	private static final Logger LOGGER = Logger.getLogger(Folkso2CSVWriter.class.getName());

	public static void write(IOF4OSMFolksonomy folkso, File file){
		
		LOGGER.log(Level.INFO, "Writing the OSM folksonomy to CSV...");
		
		try {
			FileUtils.writeStringToFile(file, parse(folkso));
			LOGGER.log(Level.INFO, "Writing the OSM folksonomy to CSV is done.");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Parsing the OSM folksonomy to CSV has encounter a problem :");
			e.printStackTrace();
		}
	}
	
	public static void write(IOF4OSMFolksonomy folkso){
		PropLoader propLoader = new PropLoader();
		String filename = propLoader.getPath() + 
        		propLoader.getProp("outputDirPath") + 
        		propLoader.getProp("outputFolksoFilename") + ".csv";
		write(folkso, new File(URI.create(filename)));
	}
	
    public static String parse(IOF4OSMFolksonomy folkso) {
    	
    	LOGGER.log(Level.INFO, "Parsing the OSM folksonomy to CSV...");

        //multipleValueCategoryTag
        String content = folkso.getTagsByType(IOSMMultipleCategoryTag.class).size() + ";multipleValueCategoryTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMMultipleCategoryTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMMultipleCategoryTag.class).get(key) + ";" + key;
        }
        
        //simpleCategoryTag
        content += "\n\n" + folkso.getTagsByType(IOSMSimpleCategoryTag.class).size() + ";simpleCategoryTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMSimpleCategoryTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMSimpleCategoryTag.class).get(key) + ";" + key;
        }
        
        // State ful Key
        // statefulCategoryTag
        content += "\n\n" + folkso.getTagsByType(IOSMStatefulCategoryTag.class).size() + ";statefulCategoryTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMStatefulCategoryTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMStatefulCategoryTag.class).get(key) + ";" + key;
        }

        // Localized Key
        // localizedKeyStringValueTag
        content += "\n\n" + folkso.getTagsByType(IOSMLocalizedKeyStringValueTag.class).size() + ";localizedKeyStringValueTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMLocalizedKeyStringValueTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMLocalizedKeyStringValueTag.class).get(key) + ";" + key;
        }

        // Simple Key
        // multipleValuePropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMMultipleValuePropertyTag.class).size() + ";multipleValuePropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMMultipleValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMMultipleValuePropertyTag.class).get(key) + ";" + key;
        }
        
        // simpleBooleanPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMSimpleKeyBooleanValuePropertyTag.class).size() + ";simpleBooleanPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMSimpleKeyBooleanValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMSimpleKeyBooleanValuePropertyTag.class).get(key) + ";" + key;
        }
        
        // simpleStringPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMSimpleKeyStringValuePropertyTag.class).size() + ";simpleStringPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMSimpleKeyStringValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMSimpleKeyStringValuePropertyTag.class).get(key) + ";" + key;
        }
        
        // simpleNumericPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMSimpleKeyNumericValuePropertyTag.class).size() + ";simpleNumericPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMSimpleKeyNumericValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMSimpleKeyNumericValuePropertyTag.class).get(key) + ";" + key;
        }
        
        // simpleDatePropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMSimpleKeyDateValuePropertyTag.class).size() + ";simpleDatePropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMSimpleKeyDateValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMSimpleKeyDateValuePropertyTag.class).get(key) + ";" + key;
        }
        
        // simpleDatePropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMTimeDomainsValuePropertyTag.class).size() + ";timeDomainsValuePropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMTimeDomainsValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMTimeDomainsValuePropertyTag.class).get(key) + ";" + key;
        }

        // Complex Key
        // complexKeyBooleanPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMComplexKeyBooleanValuePropertyTag.class).size() + ";complexKeyBooleanPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMComplexKeyBooleanValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMComplexKeyBooleanValuePropertyTag.class).get(key) + ";" + key;
        }
        
        // complexKeyStringPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMComplexKeyStringValuePropertyTag.class).size() + ";complexKeyStringPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMComplexKeyStringValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMComplexKeyStringValuePropertyTag.class).get(key) + ";" + key;
        }
        
        // complexKeyNumericPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMComplexKeyNumericValuePropertyTag.class).size() + ";complexKeyNumericPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMComplexKeyNumericValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMComplexKeyNumericValuePropertyTag.class).get(key) + ";" + key;
        }
        
        // complexKeyDatePropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMComplexKeyDateValuePropertyTag.class).size() + ";complexKeyDatePropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMComplexKeyDateValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMComplexKeyDateValuePropertyTag.class).get(key) + ";" + key;
        }

        LOGGER.log(Level.INFO, "Parsing the OSM folksonomy to CSV is done.");
        
        return content;
    }

}
