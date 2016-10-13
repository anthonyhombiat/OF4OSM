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
    
}
