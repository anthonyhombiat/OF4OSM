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
        this.value = values[0];
        this.state = values[1];
    }

    @Override
    public String getState() {
        return state;
    }

}
