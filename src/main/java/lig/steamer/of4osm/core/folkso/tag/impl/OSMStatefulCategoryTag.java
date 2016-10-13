package lig.steamer.of4osm.core.folkso.tag.impl;

import java.util.Objects;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 *
 * @author amehiris
 */
public class OSMStatefulCategoryTag extends OSMTag implements IOSMStatefulCategoryTag {

    private IOSMTagStatefulKey key; 
    
    private IOSMTagStringValue value; 

    public OSMStatefulCategoryTag(IOSMTagStatefulKey key, IOSMTagStringValue value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public IOSMTagStatefulKey getKey() {
        return key;
    }

    @Override
    public IOSMTagStringValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.key);
        hash = 89 * hash + Objects.hashCode(this.value);
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
        final OSMStatefulCategoryTag other = (OSMStatefulCategoryTag) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  key + ";" + value ;
    }
    
    
}
