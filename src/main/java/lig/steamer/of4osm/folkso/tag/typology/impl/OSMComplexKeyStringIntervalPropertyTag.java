package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagStringIntervalValue;
import lig.steamer.of4osm.folkso.tag.typology.IOSMComplexKeyStringIntervalPropertyTag;

/**
 * 
 */
public class OSMComplexKeyStringIntervalPropertyTag extends OSMTag implements IOSMComplexKeyStringIntervalPropertyTag {

    /**
     * 
     */
    public IOSMTagComplexKey key;

    /**
     * 
     */
    public IOSMTagStringIntervalValue value;

    public OSMComplexKeyStringIntervalPropertyTag(IOSMTagComplexKey key, IOSMTagStringIntervalValue value) {
        this.key = key;
        this.value = value;
    }

    public IOSMTagComplexKey getKey() {
        return key;
    }

    public IOSMTagStringIntervalValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 89 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final OSMComplexKeyStringIntervalPropertyTag other = (OSMComplexKeyStringIntervalPropertyTag) obj;
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
        return "OSMComplexKeyStringIntervalPropertyTag{" + "key=" + key + ", value=" + value + '}';
    }

}