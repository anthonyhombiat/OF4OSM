package lig.steamer.of4osm.core.folkso.tag.value.impl;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;

/**
 * 
 */
public abstract class OSMTagValue implements IOSMTagValue {

    /**
     * Default constructor
     */
    public OSMTagValue() {
       
    }

    /**
     * 
     */
    public Set<String> labels;


    /**
     * @return
     */
    public Set<String> getLabels() {
        // TODO implement here
        return null;
    }
    
}