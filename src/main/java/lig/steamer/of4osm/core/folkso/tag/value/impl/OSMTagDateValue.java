package lig.steamer.of4osm.core.folkso.tag.value.impl;

import java.util.Date;
import java.util.HashSet;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagDateValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMTagDateValue extends OSMTagValue implements IOSMTagDateValue {

    private Date value;

    public OSMTagDateValue(Date value) {
        this.value = value;
        this.labels = new HashSet<String>();
        this.labels.add(value.toString());
    }

    @Override
    public Date getValue() {
        return value;
    }

    @Override
    public String toString() {
        return labels + ";" + value;
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
        final OSMTagDateValue other = (OSMTagDateValue) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

}
