package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 *
 */
public class OSMSimpleKeyNumericValuePropertyTag extends OSMTag implements IOSMSimpleKeyNumericValuePropertyTag {

    private IOSMTagSimpleKey key;

    private IOSMTagNumericValue value;

    public OSMSimpleKeyNumericValuePropertyTag(IOSMTagSimpleKey key, IOSMTagNumericValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagSimpleKey getKey() {
        return key;
    }

    @Override
    public IOSMTagNumericValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 79 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final OSMSimpleKeyNumericValuePropertyTag other = (OSMSimpleKeyNumericValuePropertyTag) obj;
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
