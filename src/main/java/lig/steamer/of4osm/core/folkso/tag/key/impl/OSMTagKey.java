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
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OSMTagKey other = (OSMTagKey) obj;
        if ((this.value == null) ? (other.value != null) : !this.value.equals(other.value)) {
            return false;
        }
        return true;
    }

}
