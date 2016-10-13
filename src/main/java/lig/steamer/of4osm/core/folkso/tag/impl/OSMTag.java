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

}
