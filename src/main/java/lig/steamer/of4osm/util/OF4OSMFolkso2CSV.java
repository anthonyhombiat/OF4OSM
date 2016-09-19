package lig.steamer.of4osm.util;

import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
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
import lig.steamer.of4osm.core.folkso.tag.IOSMTimeDomainsValuePropertyTag;

/**
 *
 * @author amehiris
 */
public class OF4OSMFolkso2CSV {
//
//    public OF4OSMFolkso2CSV() {
//    }

    public static String parse(OF4OSMFolkso folkso) {

        //multipleValueCategoryTag
        String content = folkso.getMultipleValueCategoryTags().size() + ";multipleValueCategoryTag\n";
        for (IOSMMultipleCategoryTag key : folkso.getMultipleValueCategoryTags().keySet()) {
            content += "\n;;" + folkso.getMultipleValueCategoryTags().get(key) + ";" + key;
        }
        //simpleCategoryTag
        content += "\n\n" + folkso.getSimpleCategoryTags().size() + ";simpleCategoryTag\n";
        for (IOSMSimpleCategoryTag key : folkso.getSimpleCategoryTags().keySet()) {
            content += "\n;;" + folkso.getSimpleCategoryTags().get(key) + ";" + key;
        }
        //State ful Key
        //statefulCategoryTag
        content += "\n\n" + folkso.getStatefulCategoryTags().size() + ";statefulCategoryTag\n";
        for (IOSMStatefulCategoryTag key : folkso.getStatefulCategoryTags().keySet()) {
            content += "\n;;" + folkso.getStatefulCategoryTags().get(key) + ";" + key;
        }

        //Localized Key
        //localizedKeyStringValueTag
        content += "\n\n" + folkso.getLocalizedKeyStringValueTags().size() + ";localizedKeyStringValueTag\n";
        for (IOSMLocalizedKeyStringValueTag key : folkso.getLocalizedKeyStringValueTags().keySet()) {
            content += "\n;;" + folkso.getLocalizedKeyStringValueTags().get(key) + ";" + key;
        }

        //Simple Key
        //multipleValuePropertyTag
        content += "\n\n" + folkso.getMultipleValuePropertyTags().size() + ";multipleValuePropertyTag\n";
        for (IOSMMultipleValuePropertyTag key : folkso.getMultipleValuePropertyTags().keySet()) {
            content += "\n;;" + folkso.getMultipleValuePropertyTags().get(key) + ";" + key;
        }
        // simpleBooleanPropertyTag
        content += "\n\n" + folkso.getSimpleBooleanPropertyTags().size() + ";simpleBooleanPropertyTag\n";
        for (IOSMSimpleBooleanPropertyTag key : folkso.getSimpleBooleanPropertyTags().keySet()) {
            content += "\n;;" + folkso.getSimpleBooleanPropertyTags().get(key) + ";" + key;
        }
        // simpleStringPropertyTag
        content += "\n\n" + folkso.getSimpleStringPropertyTags().size() + ";simpleStringPropertyTag\n";
        for (IOSMSimpleStringPropertyTag key : folkso.getSimpleStringPropertyTags().keySet()) {
            content += "\n;;" + folkso.getSimpleStringPropertyTags().get(key) + ";" + key;
        }
        //   simpleNumericPropertyTag
        content += "\n\n" + folkso.getSimpleNumericPropertyTags().size() + ";simpleNumericPropertyTag\n";
        for (IOSMSimpleNumericPropertyTag key : folkso.getSimpleNumericPropertyTags().keySet()) {
            content += "\n;;" + folkso.getSimpleNumericPropertyTags().get(key) + ";" + key;
        }
        //   simpleDatePropertyTag
        content += "\n\n" + folkso.getSimpleDatePropertyTags().size() + ";simpleDatePropertyTag\n";
        for (IOSMSimpleDatePropertyTag key : folkso.getSimpleDatePropertyTags().keySet()) {
            content += "\n;;" + folkso.getSimpleDatePropertyTags().get(key) + ";" + key;
        }
        //   simpleDatePropertyTag
        content += "\n\n" + folkso.getTimeDomainsValuePropertyTags().size() + ";timeDomainsValuePropertyTag\n";
        for (IOSMTimeDomainsValuePropertyTag key : folkso.getTimeDomainsValuePropertyTags().keySet()) {
            content += "\n;;" + folkso.getTimeDomainsValuePropertyTags().get(key) + ";" + key;
        }

        // Complex Key
        // complexKeyBooleanPropertyTag
        content += "\n\n" + folkso.getComplexKeyBooleanPropertyTags().size() + ";complexKeyBooleanPropertyTag\n";
        for (IOSMComplexKeyBooleanPropertyTag key : folkso.getComplexKeyBooleanPropertyTags().keySet()) {
            content += "\n;;" + folkso.getComplexKeyBooleanPropertyTags().get(key) + ";" + key;
        }
        // complexKeyStringPropertyTag
        content += "\n\n" + folkso.getComplexKeyStringPropertyTags().size() + ";complexKeyStringPropertyTag\n";
        for (IOSMComplexKeyStringPropertyTag key : folkso.getComplexKeyStringPropertyTags().keySet()) {
            content += "\n;;" + folkso.getComplexKeyStringPropertyTags().get(key) + ";" + key;
        }
        //  complexKeyNumericPropertyTag
        content += "\n\n" + folkso.getComplexKeyNumericPropertyTags().size() + ";complexKeyNumericPropertyTag\n";
        for (IOSMComplexKeyNumericPropertyTag key : folkso.getComplexKeyNumericPropertyTags().keySet()) {
            content += "\n;;" + folkso.getComplexKeyNumericPropertyTags().get(key) + ";" + key;
        }
        // complexKeyDatePropertyTag
        content += "\n\n" + folkso.getComplexKeyDatePropertyTags().size() + ";complexKeyDatePropertyTag\n";
        for (IOSMComplexKeyDatePropertyTag key : folkso.getComplexKeyDatePropertyTags().keySet()) {
            content += "\n;;" + folkso.getComplexKeyDatePropertyTags().get(key) + ";" + key;
        }

        return content;
    }

}
