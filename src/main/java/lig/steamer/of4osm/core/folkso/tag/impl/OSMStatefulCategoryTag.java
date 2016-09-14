/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.folkso.tag.impl;

import java.util.Objects;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagValue;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;

/**
 *
 * @author amehiris
 */
public class OSMStatefulCategoryTag extends OSMTag implements IOSMStatefulCategoryTag {

    public OSMTagStatefulKey Key; 
    
    public OSMTagStringValue value; 

    public OSMStatefulCategoryTag(OSMTagStatefulKey Key, OSMTagStringValue value) {
        this.Key = Key;
        this.value = value;
    }


    public OSMTagStatefulKey getKey() {
        return Key;
    }

    public OSMTagStringValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.Key);
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
        if (!Objects.equals(this.Key, other.Key)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  Key + ";" + value ;
    }
    
    
}
