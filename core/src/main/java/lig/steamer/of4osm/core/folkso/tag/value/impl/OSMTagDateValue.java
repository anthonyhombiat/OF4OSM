package lig.steamer.of4osm.core.folkso.tag.value.impl;

import java.util.Date;

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
    }

    @Override
    public Date getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
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
   		
   		OSMTagDateValue other = (OSMTagDateValue) obj;
   		
   		if (value == null) {
   			if (other.value != null)
   				return false;
   		} else if (!value.equals(other.value))
   			return false;
   		
   		return true;
   	}

}
