package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 *
 */
public class OSMComplexKeyStringValuePropertyTag extends OSMTag implements IOSMComplexKeyStringValuePropertyTag {

    private IOSMTagComplexKey key;
    private IOSMTagStringValue value;

    public OSMComplexKeyStringValuePropertyTag(IOSMTagComplexKey key, IOSMTagStringValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagComplexKey getKey() {
        return key;
    }

    @Override
    public IOSMTagStringValue getValue() {
        return value;
    }

}
