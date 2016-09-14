package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Set;


import lig.steamer.of4osm.core.onto.meta.IOSMTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;

/**
 * 
 */
public class OSMTagCombinationConcept extends OSMTagCombinationConceptParent implements IOSMTagCombinationConcept {

    /**
     * Default constructor
     */
    public OSMTagCombinationConcept() {
    }

    /**
     * 
     */
    public IOSMTagCombinationConceptParent parents;

    /**
     * 
     */
    public IOSMTagConcept tagConcepts;

    /**
     * @return
     */
    public Set<? extends IOSMTagCombinationConceptParent> getParents() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public IOSMTagConcept getTagConcepts() {
        // TODO implement here
        return null;
    }

}