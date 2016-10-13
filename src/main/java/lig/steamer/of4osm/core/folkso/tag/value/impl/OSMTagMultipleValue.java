package lig.steamer.of4osm.core.folkso.tag.value.impl;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagMultipleValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMTagMultipleValue extends OSMTagValue implements IOSMTagMultipleValue {

    private String[] values;

    public OSMTagMultipleValue(String[] values) {
        this.values = values;
    }

    @Override
    public String[] getValues() {
        return values;
    }
    
    @Override
    public String toString() {
        String s = values[0];
        for(int i=1;i<values.length;i++){
        	s += ";" + values[i];
        }
    	return s;
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

}
