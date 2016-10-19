package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;

/**
 *
 */
public abstract class OSMTag implements IOSMTag {

    public String wikiURL;

    public OSMTag() {
    }

    @Override
    public String getWikiURL() {
        return wikiURL;
    }
    
    @Override
    public String toString(){
    	return getKey() + "=" + getValue();
    }
    
    @Override
   	public int hashCode() {
   		final int prime = 31;
   		int result = 1;
   		result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
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
   		
   		OSMTag other = (OSMTag) obj;
   		
   		if (getValue() == null) {
   			if (other.getValue() != null)
   				return false;
   		} else if (!getValue().equals(other.getValue()))
   			return false;
   		
   		return true;
   	}

}
