/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public String getState() {
        return state;
    }

}
