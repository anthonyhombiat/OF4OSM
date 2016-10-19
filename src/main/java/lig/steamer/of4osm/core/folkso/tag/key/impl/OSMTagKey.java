package lig.steamer.of4osm.core.folkso.tag.key.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public abstract class OSMTagKey implements IOSMTagKey {

    protected String value;
    protected String wikiURL;

    public OSMTagKey(String value, String wikiURL) {
        this.value = value;
        this.wikiURL = wikiURL;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getWikiURL() {
        return wikiURL;
    }

}
