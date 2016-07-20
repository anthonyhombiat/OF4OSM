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
import java.util.HashMap;
import java.util.Map;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMComplexKeyBooleanPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMComplexKeyDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMComplexKeyNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMComplexKeyStringPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMMultipleValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMSimpleBooleanPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMSimpleDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMSimpleNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMSimpleStringPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMTag;

/**
 *
 * @author amehiris
 */
public class StatTypeTags {
    //Category 

    private Map<OSMSimpleCategoryTag, Integer> simpleCategoryTag; // OSMSimpleCategoryTag
    private Map<OSMMultipleCategoryTag, Integer> multipleValueCategoryTag; //OSMMultipleValueCategoryTag

    //Property
    private Map<OSMMultipleValuePropertyTag, Integer> multipleValuePropertyTag;    //OSMMultipleValuePropertyTag

    private Map<OSMSimpleBooleanPropertyTag, Integer> simpleBooleanPropertyTag;    //OSMSimpleBooleanPropertyTag
    private Map<OSMComplexKeyBooleanPropertyTag, Integer> complexKeyBooleanPropertyTag;    //OSMComplexKeyBooleanPropertyTag

    private Map<OSMSimpleStringPropertyTag, Integer> simpleStringPropertyTag;    //OSMSimpleStringPropertyTag
    private Map<OSMComplexKeyStringPropertyTag, Integer> complexKeyStringPropertyTag;    //OSMComplexKeyStringPropertyTag

    private Map<OSMSimpleNumericPropertyTag, Integer> simpleNumericPropertyTag;    //OSMSimpleNumericPropertyTag
    private Map<OSMComplexKeyNumericPropertyTag, Integer> complexKeyNumericPropertyTag;    //OSMComplexKeyNumericPropertyTag

    private Map<OSMSimpleDatePropertyTag, Integer> simpleDatePropertyTag;   //OSMSimpleDatePropertyTag
    private Map<OSMComplexKeyDatePropertyTag, Integer> complexKeyDatePropertyTag;   //OSMComplexKeyDatePropertyTag

    public StatTypeTags() {
        this.simpleCategoryTag = new HashMap();
        this.multipleValueCategoryTag = new HashMap();
        this.multipleValuePropertyTag = new HashMap();
        this.simpleBooleanPropertyTag = new HashMap();
        this.complexKeyBooleanPropertyTag = new HashMap();
        this.simpleStringPropertyTag = new HashMap();
        this.complexKeyStringPropertyTag = new HashMap();
        this.simpleNumericPropertyTag = new HashMap();
        this.complexKeyNumericPropertyTag = new HashMap();
        this.simpleDatePropertyTag = new HashMap();
        this.complexKeyDatePropertyTag = new HashMap();
    }

    public void afficher() {
        System.out.println("\u001B[32m" + "multipleValueCategoryTag\t" + "\u001B[34m" + "size=" + multipleValueCategoryTag.size() + "\n" + multipleValueCategoryTag);

        System.out.println("\u001B[32m" + "simpleCategoryTag\t" + "\u001B[34m" + "size=" + simpleCategoryTag.size() + "\n" + simpleCategoryTag);
        System.out.println("\u001B[35m" + "Simple Key:");
        System.out.println("\u001B[32m" + "multipleValuePropertyTag\t" + "\u001B[34m" + "size=" + multipleValuePropertyTag.size() + "\n" + multipleValuePropertyTag);

        System.out.println("\u001B[32m" + "simpleBooleanPropertyTag\t" + "\u001B[34m" + "size=" + simpleBooleanPropertyTag.size() + "\n" + simpleBooleanPropertyTag);

        System.out.println("\u001B[32m" + "simpleStringPropertyTag\t" + "\u001B[34m" + "size=" + simpleStringPropertyTag.size() + "\n" + simpleStringPropertyTag);
        System.out.println("\u001B[32m" + "simpleNumericPropertyTag\t" + "\u001B[34m" + "size=" + simpleNumericPropertyTag.size() + "\n" + simpleNumericPropertyTag);

        System.out.println("\u001B[32m" + "simpleDatePropertyTag\t" + "\u001B[34m" + "size=" + simpleDatePropertyTag.size() + "\n" + simpleDatePropertyTag);

        System.out.println("\u001B[35m" + "Complex Key:");
        System.out.println("\u001B[32m" + "complexKeyBooleanPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyBooleanPropertyTag.size() + "\n" + complexKeyBooleanPropertyTag);

        System.out.println("\u001B[32m" + "complexKeyStringPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyStringPropertyTag.size() + "\n" + complexKeyStringPropertyTag);
        System.out.println("\u001B[32m" + "complexKeyNumericPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyNumericPropertyTag.size() + "\n" + complexKeyNumericPropertyTag);

        System.out.println("\u001B[32m" + "complexKeyDatePropertyTag\t" + "\u001B[34m" + "size=" + complexKeyDatePropertyTag.size() + "\n" + complexKeyDatePropertyTag);
    }

    public void addType(OSMTag type, int nbInstance) {
        if (OSMComplexKeyBooleanPropertyTag.class.isInstance(type)) {
            this.complexKeyBooleanPropertyTag.put((OSMComplexKeyBooleanPropertyTag) type, nbInstance);
        }
        if (OSMComplexKeyDatePropertyTag.class.isInstance(type)) {
            this.complexKeyDatePropertyTag.put((OSMComplexKeyDatePropertyTag) type, nbInstance);
        }
        if (OSMComplexKeyNumericPropertyTag.class.isInstance(type)) {
            this.complexKeyNumericPropertyTag.put((OSMComplexKeyNumericPropertyTag) type, nbInstance);
        }
        if (OSMComplexKeyStringPropertyTag.class.isInstance(type)) {
            this.complexKeyStringPropertyTag.put((OSMComplexKeyStringPropertyTag) type, nbInstance);
        }
        if (OSMMultipleCategoryTag.class.isInstance(type)) {
            this.multipleValueCategoryTag.put((OSMMultipleCategoryTag) type, nbInstance);
        }
        if (OSMMultipleValuePropertyTag.class.isInstance(type)) {
            this.multipleValuePropertyTag.put((OSMMultipleValuePropertyTag) type, nbInstance);
        }
        if (OSMSimpleBooleanPropertyTag.class.isInstance(type)) {
            this.simpleBooleanPropertyTag.put((OSMSimpleBooleanPropertyTag) type, nbInstance);
        }
        if (OSMSimpleCategoryTag.class.isInstance(type)) {
            this.simpleCategoryTag.put((OSMSimpleCategoryTag) type, nbInstance);
        }
        if (OSMSimpleDatePropertyTag.class.isInstance(type)) {
            this.simpleDatePropertyTag.put((OSMSimpleDatePropertyTag) type, nbInstance);
        }
        if (OSMSimpleNumericPropertyTag.class.isInstance(type)) {
            this.simpleNumericPropertyTag.put((OSMSimpleNumericPropertyTag) type, nbInstance);
        }
        if (OSMSimpleStringPropertyTag.class.isInstance(type)) {
            this.simpleStringPropertyTag.put((OSMSimpleStringPropertyTag) type, nbInstance);
        }

    }

    public void writeToFile() {

        try {
            //multipleValueCategoryTag
            String content = multipleValueCategoryTag.size() + ";multipleValueCategoryTag\n";
            for (OSMMultipleCategoryTag key : multipleValueCategoryTag.keySet()) {
                content += "\n;;" + multipleValueCategoryTag.get(key) + ";" + key;
            }
            //simpleCategoryTag
            content += "\n\n" + simpleCategoryTag.size() + ";simpleCategoryTag\n";
            for (OSMSimpleCategoryTag key : simpleCategoryTag.keySet()) {
                content += "\n;;" + simpleCategoryTag.get(key) + ";" + key;
            }

            //Simple Key
            //multipleValuePropertyTag
            content += "\n\n" + multipleValuePropertyTag.size() + ";multipleValuePropertyTag\n";
            for (OSMMultipleValuePropertyTag key : multipleValuePropertyTag.keySet()) {
                content += "\n;;" + multipleValuePropertyTag.get(key) + ";" + key;
            }
            // simpleBooleanPropertyTag
            content += "\n\n" + simpleBooleanPropertyTag.size() + ";simpleBooleanPropertyTag\n";
            for (OSMSimpleBooleanPropertyTag key : simpleBooleanPropertyTag.keySet()) {
                content += "\n;;" + simpleBooleanPropertyTag.get(key) + ";" + key;
            }
            // simpleStringPropertyTag
            content += "\n\n" + simpleStringPropertyTag.size() + ";simpleStringPropertyTag\n";
            for (OSMSimpleStringPropertyTag key : simpleStringPropertyTag.keySet()) {
                content += "\n;;" + simpleStringPropertyTag.get(key) + ";" + key;
            }
            //   simpleNumericPropertyTag
            content += "\n\n" + simpleNumericPropertyTag.size() + ";simpleNumericPropertyTag\n";
            for (OSMSimpleNumericPropertyTag key : simpleNumericPropertyTag.keySet()) {
                content += "\n;;" + simpleNumericPropertyTag.get(key) + ";" + key;
            }
            //   simpleDatePropertyTag
            content += "\n\n" + simpleDatePropertyTag.size() + ";simpleDatePropertyTag\n";
            for (OSMSimpleDatePropertyTag key : simpleDatePropertyTag.keySet()) {
                content += "\n;;" + simpleDatePropertyTag.get(key) + ";" + key;
            }
            // Complex Key
            // complexKeyBooleanPropertyTag
            content += "\n\n" + complexKeyBooleanPropertyTag.size() + ";complexKeyBooleanPropertyTag\n";
            for (OSMComplexKeyBooleanPropertyTag key : complexKeyBooleanPropertyTag.keySet()) {
                content += "\n;;" + complexKeyBooleanPropertyTag.get(key) + ";" + key;
            }
            // complexKeyStringPropertyTag
            content += "\n\n" + complexKeyStringPropertyTag.size() + ";complexKeyStringPropertyTag\n";
            for (OSMComplexKeyStringPropertyTag key : complexKeyStringPropertyTag.keySet()) {
                content += "\n;;" + complexKeyStringPropertyTag.get(key) + ";" + key;
            }
            //  complexKeyNumericPropertyTag
            content += "\n\n" + complexKeyNumericPropertyTag.size() + ";complexKeyNumericPropertyTag\n";
            for (OSMComplexKeyNumericPropertyTag key : complexKeyNumericPropertyTag.keySet()) {
                content += "\n;;" + complexKeyNumericPropertyTag.get(key) + ";" + key;
            }
            // complexKeyDatePropertyTag
            content += "\n\n" + complexKeyDatePropertyTag.size() + ";complexKeyDatePropertyTag\n";
            for (OSMComplexKeyDatePropertyTag key : complexKeyDatePropertyTag.keySet()) {
                content += "\n;;" + complexKeyDatePropertyTag.get(key) + ";" + key;
            }

           // content.getBytes(StandardCharsets.UTF_8);
            File file = new File("C:\\Users\\amehiris\\Documents\\filename1.csv");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            //fw.write(content);
            bw.append(content);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<OSMSimpleCategoryTag, Integer> getSimpleCategoryTag() {
        return simpleCategoryTag;
    }

    public Map<OSMMultipleCategoryTag, Integer> getMultipleValueCategoryTag() {
        return multipleValueCategoryTag;
    }

    public Map<OSMMultipleValuePropertyTag, Integer> getMultipleValuePropertyTag() {
        return multipleValuePropertyTag;
    }

    public Map<OSMSimpleBooleanPropertyTag, Integer> getSimpleBooleanPropertyTag() {
        return simpleBooleanPropertyTag;
    }

    public Map<OSMComplexKeyBooleanPropertyTag, Integer> getComplexKeyBooleanPropertyTag() {
        return complexKeyBooleanPropertyTag;
    }

    public Map<OSMSimpleStringPropertyTag, Integer> getSimpleStringPropertyTag() {
        return simpleStringPropertyTag;
    }

    public Map<OSMComplexKeyStringPropertyTag, Integer> getComplexKeyStringPropertyTag() {
        return complexKeyStringPropertyTag;
    }

    public Map<OSMSimpleNumericPropertyTag, Integer> getSimpleNumericPropertyTag() {
        return simpleNumericPropertyTag;
    }

    public Map<OSMComplexKeyNumericPropertyTag, Integer> getComplexKeyNumericPropertyTag() {
        return complexKeyNumericPropertyTag;
    }

    public Map<OSMSimpleDatePropertyTag, Integer> getSimpleDatePropertyTag() {
        return simpleDatePropertyTag;
    }

    public Map<OSMComplexKeyDatePropertyTag, Integer> getComplexKeyDatePropertyTag() {
        return complexKeyDatePropertyTag;
    }

}
