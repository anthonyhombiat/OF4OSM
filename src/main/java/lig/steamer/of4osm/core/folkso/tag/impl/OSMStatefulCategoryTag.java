package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 *
 * @author amehiris
 */
public class OSMStatefulCategoryTag extends OSMTag implements IOSMStatefulCategoryTag {

    private IOSMTagStatefulKey key; 
    private IOSMTagStringValue value; 

    public OSMStatefulCategoryTag(IOSMTagStatefulKey key, IOSMTagStringValue value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public IOSMTagStatefulKey getKey() {
        return key;
    }

    @Override
    public IOSMTagStringValue getValue() {
        return value;
    }
    
}
