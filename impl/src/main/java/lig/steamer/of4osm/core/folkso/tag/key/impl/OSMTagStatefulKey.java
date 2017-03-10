package lig.steamer.of4osm.core.folkso.tag.key.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;

/**
 *
 * @author amehiris
 */
public class OSMTagStatefulKey extends OSMTagKey implements IOSMTagStatefulKey {

    private String state;

    public OSMTagStatefulKey(String value, String wikiURL) {
        super(value, wikiURL);
        String[] values = value.split(":");
        this.value = values[1];
        this.state = values[0];
    }

    @Override
    public String getState() {
        return state;
    }
    
    @Override
    public String toString(){
    	return state + ":" + value;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		
		OSMTagStatefulKey other = (OSMTagStatefulKey) obj;
		
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		
		return true;
	}
    
}
