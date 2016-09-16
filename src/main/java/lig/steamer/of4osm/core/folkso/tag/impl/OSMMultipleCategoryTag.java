package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagMultipleValue;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;

/**
 * 
 */
public class OSMMultipleCategoryTag extends OSMTag implements IOSMMultipleCategoryTag {


    public IOSMTagSimpleKey key;

    /**
     * 
     */
    public IOSMTagMultipleValue value;

    public OSMMultipleCategoryTag(IOSMTagSimpleKey key, IOSMTagMultipleValue value) {
        this.key = key;
        this.value = value;
    }

    public IOSMTagSimpleKey getKey() {
        return key;
    }

    public IOSMTagMultipleValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final OSMMultipleCategoryTag other = (OSMMultipleCategoryTag) obj;
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
        return  key + ";" + value + ':';
    }


}