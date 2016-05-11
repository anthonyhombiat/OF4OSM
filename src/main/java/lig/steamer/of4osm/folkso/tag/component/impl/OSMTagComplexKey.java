package lig.steamer.of4osm.folkso.tag.component.impl;

import java.util.Set;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;

/**
 * 
 */
public class OSMTagComplexKey extends OSMTagKey implements IOSMTagComplexKey {

    /**
     * Default constructor
     */
    public OSMTagComplexKey() {
    }

    /**
     * 
     */
    public IOSMTagSimpleKey firstValue;

    /**
     * 
     */
    public Set<String> values;



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
    public Set<String> getValues() {
        // TODO implement here
        return null;
    }

}