package lig.steamer.of4osm.core.folkso.tag.key.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagLocalizedKey;

/**
 *
 * @author amehiris
 */
public class OSMTagLocalizedKey extends OSMTagKey implements IOSMTagLocalizedKey {

    private String locale;

    public OSMTagLocalizedKey(String value, String wikiURL) {
        super(value, wikiURL);
        String[] values = value.split(":");
        this.value = values[0];
        this.locale = values[1];

    }

    @Override
    public String getLocale() {
        return locale;
    }

    @Override
    public String toString() {
        return value + ":" + locale;
    }

}
