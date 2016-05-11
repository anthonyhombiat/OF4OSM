package lig.steamer.of4osm.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.onto.meta.IAristotelianConcept;
import lig.steamer.of4osm.onto.meta.IAristotelianConceptParent;
import lig.steamer.of4osm.onto.meta.IOSMTagConcept;

/**
 * 
 */
public class AristotelianConcept extends Concept implements IAristotelianConcept {

    /**
     * Default constructor
     */
    public AristotelianConcept() {
    }

    /**
     * 
     */
    public IAristotelianConceptParent parents;

    /**
     * 
     */
    public IOSMTagConcept tagConcepts;

    /**
     * @return
     */
    public Set<? extends IAristotelianConceptParent> getParents() {
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