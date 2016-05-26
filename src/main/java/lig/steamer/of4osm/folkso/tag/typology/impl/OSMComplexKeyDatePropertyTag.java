package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagDateSimpleValue;
import lig.steamer.of4osm.folkso.tag.typology.IOSMComplexKeyDatePropertyTag;

/**
 * 
 */
public class OSMComplexKeyDatePropertyTag extends OSMTag implements IOSMComplexKeyDatePropertyTag {

    /**
     * 
     */
    public IOSMTagComplexKey key;

    /**
     * 
     */
    public IOSMTagDateSimpleValue value;

    public OSMComplexKeyDatePropertyTag(IOSMTagComplexKey key, IOSMTagDateSimpleValue value) {
        this.key = key;
        this.value = value;
    }

    public IOSMTagComplexKey getKey() {
        return key;
    }

    public IOSMTagDateSimpleValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 23 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final OSMComplexKeyDatePropertyTag other = (OSMComplexKeyDatePropertyTag) obj;
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
        return "OSMComplexKeyDatePropertyTag{" + "key=" + key + ", value=" + value + '}';
    }

    
}