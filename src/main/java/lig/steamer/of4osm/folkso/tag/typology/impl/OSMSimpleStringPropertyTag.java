package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagStringSimpleValue;
import lig.steamer.of4osm.folkso.tag.typology.IOSMSimpleStringPropertyTag;

/**
 * 
 */
public class OSMSimpleStringPropertyTag extends OSMTag implements IOSMSimpleStringPropertyTag {


    /**
     * 
     */
    public IOSMTagSimpleKey key;

    /**
     * 
     */
    public IOSMTagStringSimpleValue value;

    public OSMSimpleStringPropertyTag(IOSMTagSimpleKey key, IOSMTagStringSimpleValue value) {
        this.key = key;
        this.value = value;
    }

    public IOSMTagSimpleKey getKey() {
        return key;
    }

    public IOSMTagStringSimpleValue getValue() {
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
        final OSMSimpleStringPropertyTag other = (OSMSimpleStringPropertyTag) obj;
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
        return "OSMSimpleStringPropertyTag{" + "key=" + key + ", value=" + value + '}';
    }


}