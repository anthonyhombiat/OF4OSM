package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

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
    public Set<? extends IOSMTagConceptParent> getParents() {
        return parents;
    }

}
