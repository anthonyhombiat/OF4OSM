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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 37 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final OSMComplexKeyBooleanValuePropertyTag other = (OSMComplexKeyBooleanValuePropertyTag) obj;
        if (this.key != other.key && (this.key == null || !this.key.equals(other.key))) {
            return false;
        }
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  key + ";" + value;
    }

}