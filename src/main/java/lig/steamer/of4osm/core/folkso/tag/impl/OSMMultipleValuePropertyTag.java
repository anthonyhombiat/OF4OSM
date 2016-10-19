package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagMultipleValue;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleValuePropertyTag;

/**
 *
 */
public class OSMMultipleValuePropertyTag extends OSMTag implements IOSMMultipleValuePropertyTag {

    private IOSMTagSimpleKey key;
    private IOSMTagMultipleValue value;

    public OSMMultipleValuePropertyTag(IOSMTagSimpleKey key, IOSMTagMultipleValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagSimpleKey getKey() {
        return key;
    }

    @Override
    public IOSMTagMultipleValue getValue() {
        return value;
    }

}
