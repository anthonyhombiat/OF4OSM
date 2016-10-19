package lig.steamer.of4osm.core.folkso.tag.value.impl;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagMultipleValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMTagMultipleValue extends OSMTagValue implements IOSMTagMultipleValue {

    private String[] values;

    public OSMTagMultipleValue(String[] values) {
        this.values = values;
    }

    @Override
    public String[] getValues() {
        return values;
    }
    
    @Override
    public String toString() {
        String s = values[0];
        for(int i=1;i<values.length;i++){
        	s += ";" + values[i];
        }
    	return s;
    }
    
    @Override
   	public int hashCode() {
   		final int prime = 31;
   		int result = 1;
   		result = prime * result + ((values == null) ? 0 : values.hashCode());
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
   		
   		OSMTagMultipleValue other = (OSMTagMultipleValue) obj;
   		
   		if (values == null) {
   			if (other.values != null)
   				return false;
   		} else if (!values.equals(other.values))
   			return false;
   		
   		return true;
   	}

}
