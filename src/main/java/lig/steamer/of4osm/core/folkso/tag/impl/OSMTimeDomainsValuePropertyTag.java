/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.folkso.tag.impl;

import java.util.Objects;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagTimeDomainsValue;
import lig.steamer.of4osm.core.folkso.tag.IOSMTimeDomainsValuePropertyTag;

/**
 *
 * @author amehiris
 */
public class OSMTimeDomainsValuePropertyTag extends OSMTag implements IOSMTimeDomainsValuePropertyTag{
    
    public OSMTagSimpleKey key;
    public OSMTagTimeDomainsValue value; 

    public OSMTimeDomainsValuePropertyTag(OSMTagSimpleKey key, OSMTagTimeDomainsValue value) {
        this.key = key;
        this.value = value;
    }

    public OSMTagSimpleKey getKey() {
        return key;
    }

    public OSMTagTimeDomainsValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.key);
        hash = 67 * hash + Objects.hashCode(this.value);
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
        final OSMTimeDomainsValuePropertyTag other = (OSMTimeDomainsValuePropertyTag) obj;
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
        return key + ";" + value;
    }
    
    
}
