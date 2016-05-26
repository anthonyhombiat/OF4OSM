package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagNumericSimpleValue;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagKey;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagValue;
import lig.steamer.of4osm.folkso.tag.typology.IOSMSimpleNumericPropertyTag;

/**
 * 
 */
public class OSMSimpleNumericPropertyTag extends OSMTag implements IOSMSimpleNumericPropertyTag {


    /**
     * 
     */
    public IOSMTagSimpleKey key;

    /**
     * 
     */
    public IOSMTagNumericSimpleValue value;

    public OSMSimpleNumericPropertyTag(IOSMTagSimpleKey key, IOSMTagNumericSimpleValue value) {
        this.key = key;
        this.value = value;
    }

 

    public IOSMTagSimpleKey getKey() {
        return key;
    }

    public IOSMTagNumericSimpleValue getValue() {
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
        final OSMSimpleNumericPropertyTag other = (OSMSimpleNumericPropertyTag) obj;
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
        return "OSMSimpleNumericPropertyTag{" + "key=" + key + ", value=" + value + '}';
    }

}