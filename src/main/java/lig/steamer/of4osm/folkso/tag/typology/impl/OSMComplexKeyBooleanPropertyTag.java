package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagBooleanSimpleValue;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.typology.IOSMComplexKeyBooleanPropertyTag;

/**
 * 
 */
public class OSMComplexKeyBooleanPropertyTag extends OSMTag implements IOSMComplexKeyBooleanPropertyTag {

    /**
     * Default constructor
     */
    public OSMComplexKeyBooleanPropertyTag() {
    }

    /**
     * 
     */
    public IOSMTagComplexKey key;

    /**
     * 
     */
    public IOSMTagBooleanSimpleValue value;

    /**
     * @return
     */
    public IOSMTagComplexKey getKey() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public IOSMTagBooleanSimpleValue getValue() {
        // TODO implement here
        return null;
    }

}