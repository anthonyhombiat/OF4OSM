package lig.steamer.of4osm.core.folkso.tag.key.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMTagSimpleKey extends OSMTagKey implements IOSMTagSimpleKey {

    public OSMTagSimpleKey(String value, String wikiURL) {
        super(value, wikiURL);
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
		
		OSMTagSimpleKey other = (OSMTagSimpleKey) obj;
		
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		
		return true;
	}
    
}
