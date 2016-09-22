package lig.steamer.of4osm.util;

import lig.steamer.of4osm.IOF4OSMFolkso;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyBooleanPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyStringPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMLocalizedKeyStringValueTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleBooleanPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleStringPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTimeDomainsValuePropertyTag;

/**
 *
 * @author amehiris
 */
public class Folkso2CSVParser {

    public static String parse(IOF4OSMFolkso folkso) {

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
        //State ful Key
        //statefulCategoryTag
        content += "\n\n" + folkso.getTagsByType(IOSMStatefulCategoryTag.class).size() + ";statefulCategoryTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMStatefulCategoryTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMStatefulCategoryTag.class).get(key) + ";" + key;
        }

        //Localized Key
        //localizedKeyStringValueTag
        content += "\n\n" + folkso.getTagsByType(IOSMLocalizedKeyStringValueTag.class).size() + ";localizedKeyStringValueTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMLocalizedKeyStringValueTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMLocalizedKeyStringValueTag.class).get(key) + ";" + key;
        }

        //Simple Key
        //multipleValuePropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMMultipleValuePropertyTag.class).size() + ";multipleValuePropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMMultipleValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMMultipleValuePropertyTag.class).get(key) + ";" + key;
        }
        // simpleBooleanPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMSimpleBooleanPropertyTag.class).size() + ";simpleBooleanPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMSimpleBooleanPropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMSimpleBooleanPropertyTag.class).get(key) + ";" + key;
        }
        // simpleStringPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMSimpleStringPropertyTag.class).size() + ";simpleStringPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMSimpleStringPropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMSimpleStringPropertyTag.class).get(key) + ";" + key;
        }
        //   simpleNumericPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMSimpleNumericPropertyTag.class).size() + ";simpleNumericPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMSimpleNumericPropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMSimpleNumericPropertyTag.class).get(key) + ";" + key;
        }
        //   simpleDatePropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMSimpleDatePropertyTag.class).size() + ";simpleDatePropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMSimpleDatePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMSimpleDatePropertyTag.class).get(key) + ";" + key;
        }
        //   simpleDatePropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMTimeDomainsValuePropertyTag.class).size() + ";timeDomainsValuePropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMTimeDomainsValuePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMTimeDomainsValuePropertyTag.class).get(key) + ";" + key;
        }

        // Complex Key
        // complexKeyBooleanPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMComplexKeyBooleanPropertyTag.class).size() + ";complexKeyBooleanPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMComplexKeyBooleanPropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMComplexKeyBooleanPropertyTag.class).get(key) + ";" + key;
        }
        // complexKeyStringPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMComplexKeyStringPropertyTag.class).size() + ";complexKeyStringPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMComplexKeyStringPropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMComplexKeyStringPropertyTag.class).get(key) + ";" + key;
        }
        //  complexKeyNumericPropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMComplexKeyNumericPropertyTag.class).size() + ";complexKeyNumericPropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMComplexKeyNumericPropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMComplexKeyNumericPropertyTag.class).get(key) + ";" + key;
        }
        // complexKeyDatePropertyTag
        content += "\n\n" + folkso.getTagsByType(IOSMComplexKeyDatePropertyTag.class).size() + ";complexKeyDatePropertyTag\n";
        for (IOSMTag key : folkso.getTagsByType(IOSMComplexKeyDatePropertyTag.class).keySet()) {
            content += "\n;;" + folkso.getTagsByType(IOSMComplexKeyDatePropertyTag.class).get(key) + ";" + key;
        }

        return content;
    }

}
