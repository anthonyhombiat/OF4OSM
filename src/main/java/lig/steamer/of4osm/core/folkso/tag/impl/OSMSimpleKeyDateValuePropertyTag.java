package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyDateValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagDateValue;

/**
 * 
 */
public class OSMSimpleKeyDateValuePropertyTag extends OSMTag implements IOSMSimpleKeyDateValuePropertyTag {

    private IOSMTagSimpleKey key;
    private IOSMTagDateValue value;

    public OSMSimpleKeyDateValuePropertyTag(IOSMTagSimpleKey key, IOSMTagDateValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagSimpleKey getKey() {
        return key;
    }

    @Override
    public IOSMTagDateValue getValue() {
        return value;
    }
 
}