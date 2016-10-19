package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;

/**
 * 
 */
public class OSMComplexKeyBooleanValuePropertyTag extends OSMTag implements IOSMComplexKeyBooleanValuePropertyTag {

    private IOSMTagComplexKey key;
    private IOSMTagBooleanValue value;

    public OSMComplexKeyBooleanValuePropertyTag(IOSMTagComplexKey key, IOSMTagBooleanValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagComplexKey getKey() {
        return key;
    }

    @Override
    public IOSMTagBooleanValue getValue() {
        return value;
    }

}