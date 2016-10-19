package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 *
 */
public class OSMSimpleKeyStringValuePropertyTag extends OSMTag implements IOSMSimpleKeyStringValuePropertyTag {

    private IOSMTagSimpleKey key;
    private IOSMTagStringValue value;

    public OSMSimpleKeyStringValuePropertyTag(IOSMTagSimpleKey key, IOSMTagStringValue value) {
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
