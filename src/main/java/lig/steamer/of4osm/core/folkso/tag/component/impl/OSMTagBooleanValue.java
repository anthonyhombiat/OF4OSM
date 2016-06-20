package lig.steamer.of4osm.core.folkso.tag.component.impl;

import java.util.HashSet;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagBooleanValue;

/**
 *
 */
public class OSMTagBooleanValue extends OSMTagValue implements IOSMTagBooleanValue {

    /**
     *
     */
    public Boolean value;

    public OSMTagBooleanValue(String value) {    
        this.value = value.equals("yes")||value.equals("oui")||value.equals("true") ;
        this.labels=new HashSet<String>();
        this.labels.add(value);
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return labels+";" + value ;
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
        final OSMTagBooleanValue other = (OSMTagBooleanValue) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

   

}
