/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.folkso.impl;

import java.util.HashMap;
import java.util.Map;
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
public class OF4OSMFolkso {

    //Category 
    private Map<IOSMSimpleCategoryTag, Integer> simpleCategoryTags; // OSMSimpleCategoryTag
    private Map<IOSMMultipleCategoryTag, Integer> multipleValueCategoryTags; //OSMMultipleValueCategoryTag
    private Map<IOSMStatefulCategoryTag, Integer> statefulCategoryTags; //OSMStatefulCategoryTag******
    //Property
    private Map<IOSMMultipleValuePropertyTag, Integer> multipleValuePropertyTags;    //OSMMultipleValuePropertyTag

    private Map<IOSMSimpleBooleanPropertyTag, Integer> simpleBooleanPropertyTags;    //OSMSimpleBooleanPropertyTag
    private Map<IOSMComplexKeyBooleanPropertyTag, Integer> complexKeyBooleanPropertyTags;    //OSMComplexKeyBooleanPropertyTag

    private Map<IOSMSimpleStringPropertyTag, Integer> simpleStringPropertyTags;    //OSMSimpleStringPropertyTag
    private Map<IOSMComplexKeyStringPropertyTag, Integer> complexKeyStringPropertyTags;    //OSMComplexKeyStringPropertyTag

    private Map<IOSMSimpleNumericPropertyTag, Integer> simpleNumericPropertyTags;    //OSMSimpleNumericPropertyTag
    private Map<IOSMComplexKeyNumericPropertyTag, Integer> complexKeyNumericPropertyTags;    //OSMComplexKeyNumericPropertyTag

    private Map<IOSMSimpleDatePropertyTag, Integer> simpleDatePropertyTags;   //OSMSimpleDatePropertyTag
    private Map<IOSMComplexKeyDatePropertyTag, Integer> complexKeyDatePropertyTags;   //OSMComplexKeyDatePropertyTag

    private Map<IOSMTimeDomainsValuePropertyTag, Integer> timeDomainsValuePropertyTags; //OSMTimeDomainsValuePropertyTag
    private Map<IOSMLocalizedKeyStringValueTag, Integer> localizedKeyStringValueTags; //OSMLocalizedKeyStringValueTag

    public OF4OSMFolkso() {
        this.simpleCategoryTags = new HashMap<>();
        this.multipleValueCategoryTags = new HashMap<>();
        this.statefulCategoryTags = new HashMap<>();
        this.multipleValuePropertyTags = new HashMap<>();
        this.simpleBooleanPropertyTags = new HashMap<>();
        this.complexKeyBooleanPropertyTags = new HashMap<>();
        this.simpleStringPropertyTags = new HashMap<>();
        this.complexKeyStringPropertyTags = new HashMap<>();
        this.simpleNumericPropertyTags = new HashMap<>();
        this.complexKeyNumericPropertyTags = new HashMap<>();
        this.simpleDatePropertyTags = new HashMap<>();
        this.complexKeyDatePropertyTags = new HashMap<>();
        this.timeDomainsValuePropertyTags = new HashMap<>();
        this.localizedKeyStringValueTags = new HashMap<>();
    }

    @Override
    public String toString() {
        return "\n" + "\u001B[32m" + "multipleValueCategoryTag\t" + "\u001B[34m" + "size=" + multipleValueCategoryTags.size() + "\n" + multipleValueCategoryTags
                + "\n" + "\u001B[32m" + "simpleCategoryTag\t" + "\u001B[34m" + "size=" + simpleCategoryTags.size() + "\n" + simpleCategoryTags
                + "\n" + "\u001B[35m" + "Simple Key:"
                + "\n" + "\u001B[32m" + "multipleValuePropertyTag\t" + "\u001B[34m" + "size=" + multipleValuePropertyTags.size() + "\n" + multipleValuePropertyTags
                + "\n" + "\u001B[32m" + "simpleBooleanPropertyTag\t" + "\u001B[34m" + "size=" + simpleBooleanPropertyTags.size() + "\n" + simpleBooleanPropertyTags
                + "\n" + "\u001B[32m" + "simpleStringPropertyTag\t" + "\u001B[34m" + "size=" + simpleStringPropertyTags.size() + "\n" + simpleStringPropertyTags
                + "\n" + "\u001B[32m" + "simpleNumericPropertyTag\t" + "\u001B[34m" + "size=" + simpleNumericPropertyTags.size() + "\n" + simpleNumericPropertyTags
                + "\n" + "\u001B[32m" + "simpleDatePropertyTag\t" + "\u001B[34m" + "size=" + simpleDatePropertyTags.size() + "\n" + simpleDatePropertyTags
                + "\n" + "\u001B[32m" + "timeDomainsValuePropertyTag\t" + "\u001B[34m" + "size=" + timeDomainsValuePropertyTags.size() + "\n" + timeDomainsValuePropertyTags
                + "\n" + "\u001B[35m" + "Complex Key:"
                + "\n" + "\u001B[32m" + "complexKeyBooleanPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyBooleanPropertyTags.size() + "\n" + complexKeyBooleanPropertyTags
                + "\n" + "\u001B[32m" + "complexKeyStringPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyStringPropertyTags.size() + "\n" + complexKeyStringPropertyTags
                + "\n" + "\u001B[32m" + "complexKeyNumericPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyNumericPropertyTags.size() + "\n" + complexKeyNumericPropertyTags
                + "\n" + "\u001B[32m" + "complexKeyDatePropertyTag\t" + "\u001B[34m" + "size=" + complexKeyDatePropertyTags.size() + "\n" + complexKeyDatePropertyTags
                + "\n" + "\u001B[35m" + "Localize Key:"
                + "\n" + "\u001B[32m" + "localizedKeyStringValueTag\t" + "\u001B[34m" + "size=" + localizedKeyStringValueTags.size() + "\n" + localizedKeyStringValueTags
                + "\n" + "\u001B[35m" + "State ful Key:"
                + "\n" + "\u001B[32m" + "statefulCategoryTag\t" + "\u001B[34m" + "size=" + statefulCategoryTags.size() + "\n" + statefulCategoryTags;

    }

    public void addTag(IOSMTag tag, int nbInstance) {

        if (IOSMComplexKeyBooleanPropertyTag.class.isInstance(tag)) {
            this.complexKeyBooleanPropertyTags.put((IOSMComplexKeyBooleanPropertyTag) tag, nbInstance);
        }
        if (IOSMComplexKeyDatePropertyTag.class.isInstance(tag)) {
            this.complexKeyDatePropertyTags.put((IOSMComplexKeyDatePropertyTag) tag, nbInstance);
        }
        if (IOSMComplexKeyNumericPropertyTag.class.isInstance(tag)) {
            this.complexKeyNumericPropertyTags.put((IOSMComplexKeyNumericPropertyTag) tag, nbInstance);
        }
        if (IOSMComplexKeyStringPropertyTag.class.isInstance(tag)) {
            this.complexKeyStringPropertyTags.put((IOSMComplexKeyStringPropertyTag) tag, nbInstance);
        }
        if (IOSMMultipleCategoryTag.class.isInstance(tag)) {
            this.multipleValueCategoryTags.put((IOSMMultipleCategoryTag) tag, nbInstance);
        }
        if (IOSMMultipleValuePropertyTag.class.isInstance(tag)) {
            this.multipleValuePropertyTags.put((IOSMMultipleValuePropertyTag) tag, nbInstance);
        }
        if (IOSMSimpleBooleanPropertyTag.class.isInstance(tag)) {
            this.simpleBooleanPropertyTags.put((IOSMSimpleBooleanPropertyTag) tag, nbInstance);
        }
        if (IOSMSimpleCategoryTag.class.isInstance(tag)) {
            this.simpleCategoryTags.put((IOSMSimpleCategoryTag) tag, nbInstance);
        }
        if (IOSMSimpleDatePropertyTag.class.isInstance(tag)) {
            this.simpleDatePropertyTags.put((IOSMSimpleDatePropertyTag) tag, nbInstance);
        }
        if (IOSMSimpleNumericPropertyTag.class.isInstance(tag)) {
            this.simpleNumericPropertyTags.put((IOSMSimpleNumericPropertyTag) tag, nbInstance);
        }
        if (IOSMSimpleStringPropertyTag.class.isInstance(tag)) {
            this.simpleStringPropertyTags.put((IOSMSimpleStringPropertyTag) tag, nbInstance);
        }
        if (IOSMStatefulCategoryTag.class.isInstance(tag)) {
            this.statefulCategoryTags.put((IOSMStatefulCategoryTag) tag, nbInstance);
        }
        if (IOSMTimeDomainsValuePropertyTag.class.isInstance(tag)) {
            this.timeDomainsValuePropertyTags.put((IOSMTimeDomainsValuePropertyTag) tag, nbInstance);
        }
        if (IOSMLocalizedKeyStringValueTag.class.isInstance(tag)) {
            this.localizedKeyStringValueTags.put((IOSMLocalizedKeyStringValueTag) tag, nbInstance);
        }
    }

    public Map<IOSMSimpleCategoryTag, Integer> getSimpleCategoryTags() {
        return simpleCategoryTags;
    }

    public Map<IOSMMultipleCategoryTag, Integer> getMultipleValueCategoryTags() {
        return multipleValueCategoryTags;
    }

    public Map<IOSMStatefulCategoryTag, Integer> getStatefulCategoryTags() {
        return statefulCategoryTags;
    }

    public Map<IOSMMultipleValuePropertyTag, Integer> getMultipleValuePropertyTags() {
        return multipleValuePropertyTags;
    }

    public Map<IOSMSimpleBooleanPropertyTag, Integer> getSimpleBooleanPropertyTags() {
        return simpleBooleanPropertyTags;
    }

    public Map<IOSMComplexKeyBooleanPropertyTag, Integer> getComplexKeyBooleanPropertyTags() {
        return complexKeyBooleanPropertyTags;
    }

    public Map<IOSMSimpleStringPropertyTag, Integer> getSimpleStringPropertyTags() {
        return simpleStringPropertyTags;
    }

    public Map<IOSMComplexKeyStringPropertyTag, Integer> getComplexKeyStringPropertyTags() {
        return complexKeyStringPropertyTags;
    }

    public Map<IOSMSimpleNumericPropertyTag, Integer> getSimpleNumericPropertyTags() {
        return simpleNumericPropertyTags;
    }

    public Map<IOSMComplexKeyNumericPropertyTag, Integer> getComplexKeyNumericPropertyTags() {
        return complexKeyNumericPropertyTags;
    }

    public Map<IOSMSimpleDatePropertyTag, Integer> getSimpleDatePropertyTags() {
        return simpleDatePropertyTags;
    }

    public Map<IOSMComplexKeyDatePropertyTag, Integer> getComplexKeyDatePropertyTags() {
        return complexKeyDatePropertyTags;
    }

    public Map<IOSMTimeDomainsValuePropertyTag, Integer> getTimeDomainsValuePropertyTags() {
        return timeDomainsValuePropertyTags;
    }

    public Map<IOSMLocalizedKeyStringValueTag, Integer> getLocalizedKeyStringValueTags() {
        return localizedKeyStringValueTags;
    }

    
}
