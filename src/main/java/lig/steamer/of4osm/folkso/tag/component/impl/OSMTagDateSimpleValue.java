package lig.steamer.of4osm.folkso.tag.component.impl;

import java.util.Date;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagDateSimpleValue;

/**
 *
 */
public  class OSMTagDateSimpleValue extends OSMTagValue implements IOSMTagDateSimpleValue {

    /**
     *
     */
    public Date value;

    public OSMTagDateSimpleValue(String value) {
         
        this.value = stringToDate(value);
    }

    public Date getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "OSMTagDateSimpleValue{" + "value=" + value + '}';
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
        final OSMTagDateSimpleValue other = (OSMTagDateSimpleValue) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

}
