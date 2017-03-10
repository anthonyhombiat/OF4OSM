package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMComplexKeyNumericValuePropertyTag extends OSMTag implements IOSMComplexKeyNumericValuePropertyTag {

    private IOSMTagComplexKey key;
    private IOSMTagNumericValue value;

    public OSMComplexKeyNumericValuePropertyTag(IOSMTagComplexKey key, IOSMTagNumericValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagComplexKey getKey() {
        return key;
    }

    @Override
    public IOSMTagNumericValue getValue() {
        return value;
    }

}