package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMSimpleCategoryTag extends OSMTag implements IOSMSimpleCategoryTag {

    private IOSMTagSimpleKey key;
    private IOSMTagStringValue value;

    public OSMSimpleCategoryTag(IOSMTagSimpleKey key, IOSMTagStringValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagSimpleKey getKey() {
        return key;
    }

    @Override
    public IOSMTagStringValue getValue() {
        return value;
    }

}