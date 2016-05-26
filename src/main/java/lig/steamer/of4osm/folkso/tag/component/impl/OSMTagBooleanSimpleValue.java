package lig.steamer.of4osm.folkso.tag.component.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagBooleanSimpleValue;

/**
 *
 */
public class OSMTagBooleanSimpleValue extends OSMTagValue implements IOSMTagBooleanSimpleValue {

    /**
     *
     */
    public Boolean value;

    public OSMTagBooleanSimpleValue(String value) {
        this.value = value.equals("yes")||value.equals("oui")||value.equals("true") ;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" + value + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final OSMTagBooleanSimpleValue other = (OSMTagBooleanSimpleValue) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

   

}
