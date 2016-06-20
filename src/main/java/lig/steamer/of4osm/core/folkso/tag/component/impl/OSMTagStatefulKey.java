/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.folkso.tag.component.impl;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagStatefulKey;

/**
 *
 * @author amehiris
 */
public class OSMTagStatefulKey extends OSMTagKey implements IOSMTagStatefulKey{
    
    public OSMTagStatefulKey(String value, String wikiURL) {
        super(value, wikiURL);
    }
    
}
