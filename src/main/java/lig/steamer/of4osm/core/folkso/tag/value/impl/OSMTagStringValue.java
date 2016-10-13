package lig.steamer.of4osm.core.folkso.tag.value.impl;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMTagStringValue extends OSMTagValue implements IOSMTagStringValue {

    private String value;

    public OSMTagStringValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return ""  + value ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final OSMTagStringValue other = (OSMTagStringValue) obj;
        if ((this.value == null) ? (other.value != null) : !this.value.equals(other.value)) {
            return false;
        }
        return true;
    }


}