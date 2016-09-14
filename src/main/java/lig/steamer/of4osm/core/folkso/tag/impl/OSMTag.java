package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;

/**
 * 
 */
public abstract class OSMTag implements IOSMTag {

    /**
     * Default constructor
     */
    public OSMTag() {
    }

    /**
     * 
     */
    public String wikiURL;



    /**
     * @return
     */
    public IOSMTagKey getKey() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public IOSMTagValue getValue() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getWikiURL() {
        // TODO implement here
        return "";
    }

}