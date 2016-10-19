package lig.steamer.of4osm.core.folkso.tag.key.impl;

import java.util.ArrayList;
import java.util.List;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMTagComplexKey extends OSMTagKey implements IOSMTagComplexKey {

    private List<String> prefixes;

    public OSMTagComplexKey(String value, String wikiURL) {
        super(value, wikiURL);
        String[] values = value.split(":");
        this.value = values[0];
        prefixes = new ArrayList<>();
        for(int i = 1 ; i < values.length ; i++){
        	prefixes.add(values[i]);
        }
    }

    @Override
    public List<String> getPrefixes() {
        return prefixes;
    }

    @Override
    public String toString(){
    	String s = value;
    	for(String prefixe : prefixes){
    		s += ":" + prefixe;
    	}
    	return s;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((prefixes == null) ? 0 : prefixes.hashCode());
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
		
		OSMTagComplexKey other = (OSMTagComplexKey) obj;
		
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		
		if (prefixes == null) {
			if (other.prefixes != null)
				return false;
		} else if (!prefixes.equals(other.prefixes))
			return false;
		
		return true;
	}
    
}
