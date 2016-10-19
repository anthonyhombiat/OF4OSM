package lig.steamer.of4osm.core.folkso.tag.value.impl;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagTimeDomainsValue;

/**
 *
 * @author amehiris
 */
public class OSMTagTimeDomainsValue extends OSMTagValue implements IOSMTagTimeDomainsValue {

    private String value;

    public OSMTagTimeDomainsValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
   	public int hashCode() {
   		final int prime = 31;
   		int result = 1;
   		result = prime * result + ((value == null) ? 0 : value.hashCode());
   		return result;
   	}

   	@Override
   	public boolean equals(Object obj) {
   		
   		if (this == obj)
   			return true;
   		
   		if (obj == null)
   			return false;
   		
   		if (getClass() != obj.getClass())
   			return false;
   		
   		OSMTagTimeDomainsValue other = (OSMTagTimeDomainsValue) obj;
   		
   		if (value == null) {
   			if (other.value != null)
   				return false;
   		} else if (!value.equals(other.value))
   			return false;
   		
   		return true;
   	}

}
