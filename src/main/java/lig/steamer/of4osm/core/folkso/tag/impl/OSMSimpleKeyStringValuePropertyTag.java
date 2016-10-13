package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 *
 */
public class OSMSimpleKeyStringValuePropertyTag extends OSMTag implements IOSMSimpleKeyStringValuePropertyTag {

    private IOSMTagSimpleKey key;

    private IOSMTagStringValue value;

    public OSMSimpleKeyStringValuePropertyTag(IOSMTagSimpleKey key, IOSMTagStringValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagSimpleKey getKey() {
        return key;
    }

    @Override
    public IOSMTagStringValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 41 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final OSMSimpleKeyStringValuePropertyTag other = (OSMSimpleKeyStringValuePropertyTag) obj;
        if (this.key != other.key && (this.key == null || !this.key.equals(other.key))) {
            return false;
        }
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

}
