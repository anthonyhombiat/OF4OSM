package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMSimpleKeyNumericValuePropertyTag extends OSMTag implements IOSMSimpleKeyNumericValuePropertyTag {

    private IOSMTagSimpleKey key;
    private IOSMTagNumericValue value;

    public OSMSimpleKeyNumericValuePropertyTag(IOSMTagSimpleKey key, IOSMTagNumericValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagSimpleKey getKey() {
        return key;
    }

    @Override
    public IOSMTagNumericValue getValue() {
        return value;
    }

}