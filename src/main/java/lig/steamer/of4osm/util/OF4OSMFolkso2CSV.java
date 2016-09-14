/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyBooleanPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyStringPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMLocalizedKeyStringValueTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMMultipleValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleBooleanPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleStringPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMTimeDomainsValuePropertyTag;

/**
 *
 * @author amehiris
 */
public class OF4OSMFolkso2CSV {

    public OF4OSMFolkso2CSV() {
    }

    public String parse(OF4OSMFolkso folkso) {

        //multipleValueCategoryTag
        String content = folkso.getMultipleValueCategoryTag().size() + ";multipleValueCategoryTag\n";
        for (OSMMultipleCategoryTag key : folkso.getMultipleValueCategoryTag().keySet()) {
            content += "\n;;" + folkso.getMultipleValueCategoryTag().get(key) + ";" + key;
        }
        //simpleCategoryTag
        content += "\n\n" + folkso.getSimpleCategoryTag().size() + ";simpleCategoryTag\n";
        for (OSMSimpleCategoryTag key : folkso.getSimpleCategoryTag().keySet()) {
            content += "\n;;" + folkso.getSimpleCategoryTag().get(key) + ";" + key;
        }
        //State ful Key
        //statefulCategoryTag
        content += "\n\n" + folkso.getStatefulCategoryTag().size() + ";statefulCategoryTag\n";
        for (OSMStatefulCategoryTag key : folkso.getStatefulCategoryTag().keySet()) {
            content += "\n;;" + folkso.getStatefulCategoryTag().get(key) + ";" + key;
        }

        //Localized Key
        //localizedKeyStringValueTag
        content += "\n\n" + folkso.getLocalizedKeyStringValueTag().size() + ";localizedKeyStringValueTag\n";
        for (OSMLocalizedKeyStringValueTag key : folkso.getLocalizedKeyStringValueTag().keySet()) {
            content += "\n;;" + folkso.getLocalizedKeyStringValueTag().get(key) + ";" + key;
        }

        //Simple Key
        //multipleValuePropertyTag
        content += "\n\n" + folkso.getMultipleValuePropertyTag().size() + ";multipleValuePropertyTag\n";
        for (OSMMultipleValuePropertyTag key : folkso.getMultipleValuePropertyTag().keySet()) {
            content += "\n;;" + folkso.getMultipleValuePropertyTag().get(key) + ";" + key;
        }
        // simpleBooleanPropertyTag
        content += "\n\n" + folkso.getSimpleBooleanPropertyTag().size() + ";simpleBooleanPropertyTag\n";
        for (OSMSimpleBooleanPropertyTag key : folkso.getSimpleBooleanPropertyTag().keySet()) {
            content += "\n;;" + folkso.getSimpleBooleanPropertyTag().get(key) + ";" + key;
        }
        // simpleStringPropertyTag
        content += "\n\n" + folkso.getSimpleStringPropertyTag().size() + ";simpleStringPropertyTag\n";
        for (OSMSimpleStringPropertyTag key : folkso.getSimpleStringPropertyTag().keySet()) {
            content += "\n;;" + folkso.getSimpleStringPropertyTag().get(key) + ";" + key;
        }
        //   simpleNumericPropertyTag
        content += "\n\n" + folkso.getSimpleNumericPropertyTag().size() + ";simpleNumericPropertyTag\n";
        for (OSMSimpleNumericPropertyTag key : folkso.getSimpleNumericPropertyTag().keySet()) {
            content += "\n;;" + folkso.getSimpleNumericPropertyTag().get(key) + ";" + key;
        }
        //   simpleDatePropertyTag
        content += "\n\n" + folkso.getSimpleDatePropertyTag().size() + ";simpleDatePropertyTag\n";
        for (OSMSimpleDatePropertyTag key : folkso.getSimpleDatePropertyTag().keySet()) {
            content += "\n;;" + folkso.getSimpleDatePropertyTag().get(key) + ";" + key;
        }
        //   simpleDatePropertyTag
        content += "\n\n" + folkso.getTimeDomainsValuePropertyTag().size() + ";timeDomainsValuePropertyTag\n";
        for (OSMTimeDomainsValuePropertyTag key : folkso.getTimeDomainsValuePropertyTag().keySet()) {
            content += "\n;;" + folkso.getTimeDomainsValuePropertyTag().get(key) + ";" + key;
        }

        // Complex Key
        // complexKeyBooleanPropertyTag
        content += "\n\n" + folkso.getComplexKeyBooleanPropertyTag().size() + ";complexKeyBooleanPropertyTag\n";
        for (OSMComplexKeyBooleanPropertyTag key : folkso.getComplexKeyBooleanPropertyTag().keySet()) {
            content += "\n;;" + folkso.getComplexKeyBooleanPropertyTag().get(key) + ";" + key;
        }
        // complexKeyStringPropertyTag
        content += "\n\n" + folkso.getComplexKeyStringPropertyTag().size() + ";complexKeyStringPropertyTag\n";
        for (OSMComplexKeyStringPropertyTag key : folkso.getComplexKeyStringPropertyTag().keySet()) {
            content += "\n;;" + folkso.getComplexKeyStringPropertyTag().get(key) + ";" + key;
        }
        //  complexKeyNumericPropertyTag
        content += "\n\n" + folkso.getComplexKeyNumericPropertyTag().size() + ";complexKeyNumericPropertyTag\n";
        for (OSMComplexKeyNumericPropertyTag key : folkso.getComplexKeyNumericPropertyTag().keySet()) {
            content += "\n;;" + folkso.getComplexKeyNumericPropertyTag().get(key) + ";" + key;
        }
        // complexKeyDatePropertyTag
        content += "\n\n" + folkso.getComplexKeyDatePropertyTag().size() + ";complexKeyDatePropertyTag\n";
        for (OSMComplexKeyDatePropertyTag key : folkso.getComplexKeyDatePropertyTag().keySet()) {
            content += "\n;;" + folkso.getComplexKeyDatePropertyTag().get(key) + ";" + key;
        }

        return content;
    }

    public void write(String content, String path) {
        try {

            // content.getBytes(StandardCharsets.UTF_8);
            File file = new File(path);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(content);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
