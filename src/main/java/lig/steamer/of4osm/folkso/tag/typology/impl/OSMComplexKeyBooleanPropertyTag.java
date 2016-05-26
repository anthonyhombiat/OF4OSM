package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagBooleanSimpleValue;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.typology.IOSMComplexKeyBooleanPropertyTag;

/**
 * 
 */
public class OSMComplexKeyBooleanPropertyTag extends OSMTag implements IOSMComplexKeyBooleanPropertyTag {

    /**
     * 
     */
    public IOSMTagComplexKey key;

    /**
     * 
     */
    public IOSMTagBooleanSimpleValue value;

    public OSMComplexKeyBooleanPropertyTag(IOSMTagComplexKey key, IOSMTagBooleanSimpleValue value) {
        this.key = key;
        this.value = value;
    }

    public IOSMTagComplexKey getKey() {
        return key;
    }

    public IOSMTagBooleanSimpleValue getValue() {
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
        final OSMComplexKeyBooleanPropertyTag other = (OSMComplexKeyBooleanPropertyTag) obj;
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
        return "OSMComplexKeyBooleanPropertyTag{" + "key=" + key + ", value=" + value + '}';
    }

}