package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagNumericIntervalValue;
import lig.steamer.of4osm.folkso.tag.typology.IOSMComplexKeyNumericIntervalPropertyTag;

/**
 * 
 */
public class OSMComplexKeyNumericIntervalPropertyTag extends OSMTag implements IOSMComplexKeyNumericIntervalPropertyTag {

    /**
     * 
     */
    public IOSMTagComplexKey key;

    /**
     * 
     */
    public IOSMTagNumericIntervalValue value;

    public OSMComplexKeyNumericIntervalPropertyTag(IOSMTagComplexKey key, IOSMTagNumericIntervalValue value) {
        this.key = key;
        this.value = value;
    }

    public IOSMTagComplexKey getKey() {
        return key;
    }

    public IOSMTagNumericIntervalValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 97 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final OSMComplexKeyNumericIntervalPropertyTag other = (OSMComplexKeyNumericIntervalPropertyTag) obj;
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
        return "OSMComplexKeyNumericIntervalPropertyTag{" + "key=" + key + ", value=" + value + '}';
    }



}