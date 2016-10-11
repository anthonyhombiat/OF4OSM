package lig.steamer.of4osm.core.folkso.tag.value.impl;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMTagNumericValue extends OSMTagValue implements IOSMTagNumericValue {

    private Double value;

    public OSMTagNumericValue(Double value) {
        this.value = value;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final OSMTagNumericValue other = (OSMTagNumericValue) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

}
