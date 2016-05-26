package lig.steamer.of4osm.folkso.tag.component.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagNumericSimpleValue;

/**
 * 
 */
public class OSMTagNumericSimpleValue extends OSMTagValue implements IOSMTagNumericSimpleValue {


    /**
     * 
     */
    public Double value;

    public OSMTagNumericSimpleValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{"  + value + '}';
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
        final OSMTagNumericSimpleValue other = (OSMTagNumericSimpleValue) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

    /**
     * @return
     */
    public Double getValue() {
        // TODO implement here
        return null;
    }

}