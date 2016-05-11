package lig.steamer.of4osm.folkso.tag.component.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagKey;

/**
 * 
 */
public abstract class OSMTagKey implements IOSMTagKey {

    /**
     * Default constructor
     */
    public OSMTagKey() {
    }

    /**
     * 
     */
    public String value;

    /**
     * 
     */
    public String wikiURL;


    /**
     * @return
     */
    public String getValue() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getWikiURL() {
        // TODO implement here
        return "";
    }

}