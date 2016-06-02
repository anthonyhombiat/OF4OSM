package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IConcept;

/**
 * 
 */
public abstract class Concept implements IConcept {

    /**
     * Default constructor
     */
    public Concept() {
    }

    /**
     * 
     */
    public Set<String> labels;


    /**
     * @return
     */
    public abstract Set<? extends IConcept> getParents();

    /**
     * @return
     */
    public Set<String> getLabels() {
        // TODO implement here
        return null;
    }

}