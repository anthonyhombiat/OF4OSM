/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.folkso.tag.component.impl;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagLocalizedKey;

/**
 *
 * @author amehiris
 */
public class OSMTagLocalizedKey extends OSMTagKey implements IOSMTagLocalizedKey {

    public String locale;

    public OSMTagLocalizedKey(String value, String wikiURL) {
        super(value, wikiURL);
        String[] values = value.split(":");
        this.value = values[0];
        this.locale = values[1];

    }

    public String getLocale() {
        return locale;
    }

}
