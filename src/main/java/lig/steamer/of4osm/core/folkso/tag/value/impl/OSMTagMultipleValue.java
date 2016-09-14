package lig.steamer.of4osm.core.folkso.tag.value.impl;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagMultipleValue;

/**
 * 
 */
public class OSMTagMultipleValue extends OSMTagValue implements IOSMTagMultipleValue {

   
    /**
     * 
     */
    public String values;

    public OSMTagMultipleValue(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "" + values ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.values != null ? this.values.hashCode() : 0);
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
        final OSMTagMultipleValue other = (OSMTagMultipleValue) obj;
        if ((this.values == null) ? (other.values != null) : !this.values.equals(other.values)) {
            return false;
        }
        return true;
    }

    /**
     * @return
     */
    public String getValues() {
        // TODO implement here
        return "";
    }

}