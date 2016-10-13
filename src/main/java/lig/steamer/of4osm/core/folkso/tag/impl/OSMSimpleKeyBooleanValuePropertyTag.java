package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;

/**
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 71 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OSMSimpleKeyBooleanValuePropertyTag other = (OSMSimpleKeyBooleanValuePropertyTag) obj;
        if (this.key != other.key && (this.key == null || !this.key.equals(other.key))) {
            return false;
        }
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }
    
}