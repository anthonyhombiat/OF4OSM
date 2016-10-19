package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyDateValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagDateValue;

/**
 *
 */
public class OSMComplexKeyDateValuePropertyTag extends OSMTag implements IOSMComplexKeyDateValuePropertyTag {

    private IOSMTagComplexKey key;
    private IOSMTagDateValue value;

    public OSMComplexKeyDateValuePropertyTag(IOSMTagComplexKey key, IOSMTagDateValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagComplexKey getKey() {
        return key;
    }

    @Override
    public IOSMTagDateValue getValue() {
        return value;
    }

}
