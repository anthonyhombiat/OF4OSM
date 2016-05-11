package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTag;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagValue;

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