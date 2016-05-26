package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagStringSimpleValue;
import lig.steamer.of4osm.folkso.tag.typology.IOSMComplexKeyStringPropertyTag;

/**
 * 
 */
public class OSMComplexKeyStringPropertyTag extends OSMTag implements IOSMComplexKeyStringPropertyTag {

    /**
     * 
     */
    public IOSMTagComplexKey key;

    /**
     * 
     */
    public IOSMTagStringSimpleValue value;

    public OSMComplexKeyStringPropertyTag(IOSMTagComplexKey key, IOSMTagStringSimpleValue value) {
        this.key = key;
        this.value = value;
    }

    public IOSMTagComplexKey getKey() {
        return key;
    }

    public IOSMTagStringSimpleValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final OSMComplexKeyStringPropertyTag other = (OSMComplexKeyStringPropertyTag) obj;
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
        return "OSMComplexKeyStringPropertyTag{" + "key=" + key + ", value=" + value + '}';
    }

}