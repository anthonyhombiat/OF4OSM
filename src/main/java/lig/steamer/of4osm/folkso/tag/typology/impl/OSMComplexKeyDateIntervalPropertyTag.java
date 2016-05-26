package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagDateIntervalValue;
import lig.steamer.of4osm.folkso.tag.typology.IOSMComplexKeyDateIntervalPropertyTag;

/**
 * 
 */
public class OSMComplexKeyDateIntervalPropertyTag extends OSMTag implements IOSMComplexKeyDateIntervalPropertyTag {

    /**
     * 
     */
    public IOSMTagComplexKey key;

    /**
     * 
     */
    public IOSMTagDateIntervalValue value;

    public OSMComplexKeyDateIntervalPropertyTag(IOSMTagComplexKey key, IOSMTagDateIntervalValue value) {
        this.key = key;
        this.value = value;
    }

    public IOSMTagComplexKey getKey() {
        return key;
    }

    public IOSMTagDateIntervalValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 61 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final OSMComplexKeyDateIntervalPropertyTag other = (OSMComplexKeyDateIntervalPropertyTag) obj;
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
        return "OSMComplexKeyDateIntervalPropertyTag{" + "key=" + key + ", value=" + value + '}';
    }

}