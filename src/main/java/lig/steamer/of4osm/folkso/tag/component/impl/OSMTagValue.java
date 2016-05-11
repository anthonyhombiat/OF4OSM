package lig.steamer.of4osm.folkso.tag.component.impl;

import java.util.Set;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagValue;

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