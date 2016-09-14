/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.folkso.tag.impl;

import java.util.Objects;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.IOSMLocalizedKeyStringValueTag;

/**
 *
 * @author amehiris
 */
public class OSMLocalizedKeyStringValueTag extends OSMTag implements IOSMLocalizedKeyStringValueTag {

    public OSMTagLocalizedKey key;
    public OSMTagStringValue value;

    public OSMLocalizedKeyStringValueTag(OSMTagLocalizedKey key, OSMTagStringValue value) {
        this.key = key;
        this.value = value;
    }

    public OSMTagLocalizedKey getKey() {
        return key;
    }

    public OSMTagStringValue getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.key);
        hash = 29 * hash + Objects.hashCode(this.value);
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
        final OSMLocalizedKeyStringValueTag other = (OSMLocalizedKeyStringValueTag) obj;
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
