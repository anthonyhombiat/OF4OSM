/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.folkso.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
import lig.steamer.of4osm.core.folkso.tag.impl.OSMTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMTimeDomainsValuePropertyTag;

/**
 *
 * @author amehiris
 */
public class OF4OSMFolkso {

    //Category 
    private Map<OSMSimpleCategoryTag, Integer> simpleCategoryTag; // OSMSimpleCategoryTag
    private Map<OSMMultipleCategoryTag, Integer> multipleValueCategoryTag; //OSMMultipleValueCategoryTag
    private Map<OSMStatefulCategoryTag, Integer> statefulCategoryTag; //OSMStatefulCategoryTag******
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

    private Map<OSMTimeDomainsValuePropertyTag, Integer> timeDomainsValuePropertyTag; //OSMTimeDomainsValuePropertyTag
    private Map<OSMLocalizedKeyStringValueTag, Integer> localizedKeyStringValueTag; //OSMLocalizedKeyStringValueTag

    public OF4OSMFolkso() {
        this.simpleCategoryTag = new HashMap();
        this.multipleValueCategoryTag = new HashMap();
        this.statefulCategoryTag = new HashMap();
        this.multipleValuePropertyTag = new HashMap();
        this.simpleBooleanPropertyTag = new HashMap();
        this.complexKeyBooleanPropertyTag = new HashMap();
        this.simpleStringPropertyTag = new HashMap();
        this.complexKeyStringPropertyTag = new HashMap();
        this.simpleNumericPropertyTag = new HashMap();
        this.complexKeyNumericPropertyTag = new HashMap();
        this.simpleDatePropertyTag = new HashMap();
        this.complexKeyDatePropertyTag = new HashMap();
        this.timeDomainsValuePropertyTag = new HashMap();
        this.localizedKeyStringValueTag = new HashMap();
    }

    @Override
    public String toString() {
        return "\n" + "\u001B[32m" + "multipleValueCategoryTag\t" + "\u001B[34m" + "size=" + multipleValueCategoryTag.size() + "\n" + multipleValueCategoryTag
                + "\n" + "\u001B[32m" + "simpleCategoryTag\t" + "\u001B[34m" + "size=" + simpleCategoryTag.size() + "\n" + simpleCategoryTag
                + "\n" + "\u001B[35m" + "Simple Key:"
                + "\n" + "\u001B[32m" + "multipleValuePropertyTag\t" + "\u001B[34m" + "size=" + multipleValuePropertyTag.size() + "\n" + multipleValuePropertyTag
                + "\n" + "\u001B[32m" + "simpleBooleanPropertyTag\t" + "\u001B[34m" + "size=" + simpleBooleanPropertyTag.size() + "\n" + simpleBooleanPropertyTag
                + "\n" + "\u001B[32m" + "simpleStringPropertyTag\t" + "\u001B[34m" + "size=" + simpleStringPropertyTag.size() + "\n" + simpleStringPropertyTag
                + "\n" + "\u001B[32m" + "simpleNumericPropertyTag\t" + "\u001B[34m" + "size=" + simpleNumericPropertyTag.size() + "\n" + simpleNumericPropertyTag
                + "\n" + "\u001B[32m" + "simpleDatePropertyTag\t" + "\u001B[34m" + "size=" + simpleDatePropertyTag.size() + "\n" + simpleDatePropertyTag
                + "\n" + "\u001B[32m" + "timeDomainsValuePropertyTag\t" + "\u001B[34m" + "size=" + timeDomainsValuePropertyTag.size() + "\n" + timeDomainsValuePropertyTag
                + "\n" + "\u001B[35m" + "Complex Key:"
                + "\n" + "\u001B[32m" + "complexKeyBooleanPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyBooleanPropertyTag.size() + "\n" + complexKeyBooleanPropertyTag
                + "\n" + "\u001B[32m" + "complexKeyStringPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyStringPropertyTag.size() + "\n" + complexKeyStringPropertyTag
                + "\n" + "\u001B[32m" + "complexKeyNumericPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyNumericPropertyTag.size() + "\n" + complexKeyNumericPropertyTag
                + "\n" + "\u001B[32m" + "complexKeyDatePropertyTag\t" + "\u001B[34m" + "size=" + complexKeyDatePropertyTag.size() + "\n" + complexKeyDatePropertyTag
                + "\n" + "\u001B[35m" + "Localize Key:"
                + "\n" + "\u001B[32m" + "localizedKeyStringValueTag\t" + "\u001B[34m" + "size=" + localizedKeyStringValueTag.size() + "\n" + localizedKeyStringValueTag
                + "\n" + "\u001B[35m" + "State ful Key:"
                + "\n" + "\u001B[32m" + "statefulCategoryTag\t" + "\u001B[34m" + "size=" + statefulCategoryTag.size() + "\n" + statefulCategoryTag;

    }

    public void addTag(OSMTag tag, int nbInstance) {

        if (OSMComplexKeyBooleanPropertyTag.class.isInstance(tag)) {
            this.complexKeyBooleanPropertyTag.put((OSMComplexKeyBooleanPropertyTag) tag, nbInstance);
        }
        if (OSMComplexKeyDatePropertyTag.class.isInstance(tag)) {
            this.complexKeyDatePropertyTag.put((OSMComplexKeyDatePropertyTag) tag, nbInstance);
        }
        if (OSMComplexKeyNumericPropertyTag.class.isInstance(tag)) {
            this.complexKeyNumericPropertyTag.put((OSMComplexKeyNumericPropertyTag) tag, nbInstance);
        }
        if (OSMComplexKeyStringPropertyTag.class.isInstance(tag)) {
            this.complexKeyStringPropertyTag.put((OSMComplexKeyStringPropertyTag) tag, nbInstance);
        }
        if (OSMMultipleCategoryTag.class.isInstance(tag)) {
            this.multipleValueCategoryTag.put((OSMMultipleCategoryTag) tag, nbInstance);
        }
        if (OSMMultipleValuePropertyTag.class.isInstance(tag)) {
            this.multipleValuePropertyTag.put((OSMMultipleValuePropertyTag) tag, nbInstance);
        }
        if (OSMSimpleBooleanPropertyTag.class.isInstance(tag)) {
            this.simpleBooleanPropertyTag.put((OSMSimpleBooleanPropertyTag) tag, nbInstance);
        }
        if (OSMSimpleCategoryTag.class.isInstance(tag)) {
            this.simpleCategoryTag.put((OSMSimpleCategoryTag) tag, nbInstance);
        }
        if (OSMSimpleDatePropertyTag.class.isInstance(tag)) {
            this.simpleDatePropertyTag.put((OSMSimpleDatePropertyTag) tag, nbInstance);
        }
        if (OSMSimpleNumericPropertyTag.class.isInstance(tag)) {
            this.simpleNumericPropertyTag.put((OSMSimpleNumericPropertyTag) tag, nbInstance);
        }
        if (OSMSimpleStringPropertyTag.class.isInstance(tag)) {
            this.simpleStringPropertyTag.put((OSMSimpleStringPropertyTag) tag, nbInstance);
        }
        if (OSMStatefulCategoryTag.class.isInstance(tag)) {
            this.statefulCategoryTag.put((OSMStatefulCategoryTag) tag, nbInstance);
        }
        if (OSMTimeDomainsValuePropertyTag.class.isInstance(tag)) {
            this.timeDomainsValuePropertyTag.put((OSMTimeDomainsValuePropertyTag) tag, nbInstance);
        }
        if (OSMLocalizedKeyStringValueTag.class.isInstance(tag)) {
            this.localizedKeyStringValueTag.put((OSMLocalizedKeyStringValueTag) tag, nbInstance);
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
            //State ful Key
            //statefulCategoryTag
            content += "\n\n" + statefulCategoryTag.size() + ";statefulCategoryTag\n";
            for (OSMStatefulCategoryTag key : statefulCategoryTag.keySet()) {
                content += "\n;;" + statefulCategoryTag.get(key) + ";" + key;
            }

            //Localized Key
            //localizedKeyStringValueTag
            content += "\n\n" + localizedKeyStringValueTag.size() + ";localizedKeyStringValueTag\n";
            for (OSMLocalizedKeyStringValueTag key : localizedKeyStringValueTag.keySet()) {
                content += "\n;;" + localizedKeyStringValueTag.get(key) + ";" + key;
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
            //   simpleDatePropertyTag
            content += "\n\n" + timeDomainsValuePropertyTag.size() + ";timeDomainsValuePropertyTag\n";
            for (OSMTimeDomainsValuePropertyTag key : timeDomainsValuePropertyTag.keySet()) {
                content += "\n;;" + timeDomainsValuePropertyTag.get(key) + ";" + key;
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

    public Map<OSMStatefulCategoryTag, Integer> getStatefulCategoryTag() {
        return statefulCategoryTag;
    }

    public Map<OSMTimeDomainsValuePropertyTag, Integer> getTimeDomainsValuePropertyTag() {
        return timeDomainsValuePropertyTag;
    }

    public Map<OSMLocalizedKeyStringValueTag, Integer> getLocalizedKeyStringValueTag() {
        return localizedKeyStringValueTag;
    }

}
