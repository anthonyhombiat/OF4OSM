package lig.steamer.of4osm.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.folkso.tag.component.IOSMTag;
import lig.steamer.of4osm.onto.meta.IOSMTagConcept;
import lig.steamer.of4osm.onto.meta.IOSMTagConceptParent;

/**
 * 
 */
public abstract class OSMTagConcept extends Concept implements IOSMTagConcept {

    /**
     * Default constructor
     */
    public OSMTagConcept() {
    }

    /**
     * 
     */
    public Set<IOSMTagConceptParent> parents;

    /**
     * @return
     */
    public abstract IOSMTag getTag();

    /**
     * @return
     */
    public abstract Set<? extends IOSMTagConceptParent> getParents();

}