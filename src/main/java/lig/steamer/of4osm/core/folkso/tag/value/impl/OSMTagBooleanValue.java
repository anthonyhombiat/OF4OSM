package lig.steamer.of4osm.core.folkso.tag.value.impl;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMTagBooleanValue extends OSMTagValue implements IOSMTagBooleanValue {

    private Boolean value;

    public OSMTagBooleanValue(Boolean value) {    
        this.value = value ;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString() ;
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
		
		OSMTagBooleanValue other = (OSMTagBooleanValue) obj;
		
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		
		return true;
	}

}
