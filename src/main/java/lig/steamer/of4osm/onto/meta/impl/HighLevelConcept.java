package lig.steamer.of4osm.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.onto.meta.IHighLevelConcept;

/**
 * 
 */
public class HighLevelConcept extends Concept implements IHighLevelConcept {

    /**
     * Default constructor
     */
    public HighLevelConcept() {
    }

    /**
     * 
     */
    public Set<IHighLevelConcept> parents;

    /**
     * 
     */
    public String description;

    /**
     * @return
     */
    public Set<? extends IHighLevelConcept> getParents() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getDescription() {
        // TODO implement here
        return "";
    }

}