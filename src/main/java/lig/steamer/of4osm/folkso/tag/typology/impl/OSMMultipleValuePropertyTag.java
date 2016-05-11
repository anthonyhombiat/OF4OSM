package lig.steamer.of4osm.folkso.tag.typology.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagMultipleValue;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;
import lig.steamer.of4osm.folkso.tag.typology.IOSMMultipleValuePropertyTag;

/**
 * 
 */
public class OSMMultipleValuePropertyTag extends OSMTag implements IOSMMultipleValuePropertyTag {

    /**
     * Default constructor
     */
    public OSMMultipleValuePropertyTag() {
    }

    /**
     * 
     */
    public IOSMTagSimpleKey key;

    /**
     * 
     */
    public IOSMTagMultipleValue value;

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public IOSMTagMultipleValue getValue() {
        // TODO implement here
        return null;
    }

}