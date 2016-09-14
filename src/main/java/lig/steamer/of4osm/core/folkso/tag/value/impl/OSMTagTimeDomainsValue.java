/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.folkso.tag.value.impl;

import java.util.Objects;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagTimeDomainsValue;

/**
 *
 * @author amehiris
 */
public class OSMTagTimeDomainsValue extends OSMTagValue implements IOSMTagTimeDomainsValue{
    
    public String timeDomains;

    public OSMTagTimeDomainsValue(String value) {
        this.timeDomains = value;
    }

    @Override
    public String toString() {
        return  " " + timeDomains ;
    }

    public String getValue() {
        return timeDomains;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.timeDomains);
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
        final OSMTagTimeDomainsValue other = (OSMTagTimeDomainsValue) obj;
        if (!Objects.equals(this.timeDomains, other.timeDomains)) {
            return false;
        }
        return true;
    }
    
    
}
