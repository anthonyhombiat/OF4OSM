package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMSimpleKeyBooleanValuePropertyTag extends OSMTag implements IOSMSimpleKeyBooleanValuePropertyTag {

    private IOSMTagSimpleKey key;
    private IOSMTagBooleanValue value;

    public OSMSimpleKeyBooleanValuePropertyTag(IOSMTagSimpleKey key, IOSMTagBooleanValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagSimpleKey getKey() {
        return key;
    }

    @Override
    public IOSMTagBooleanValue getValue() {
        return value;
    }
    
}