package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 *
 */
public class OSMComplexKeyNumericPropertyTag extends OSMTag implements IOSMComplexKeyNumericPropertyTag {

    private IOSMTagComplexKey key;

    private IOSMTagNumericValue value;

    public OSMComplexKeyNumericPropertyTag(IOSMTagComplexKey key, IOSMTagNumericValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagComplexKey getKey() {
        return key;
    }

    @Override
    public IOSMTagNumericValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 13 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final OSMComplexKeyNumericPropertyTag other = (OSMComplexKeyNumericPropertyTag) obj;
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
        return key + ";" + value;
    }

}
