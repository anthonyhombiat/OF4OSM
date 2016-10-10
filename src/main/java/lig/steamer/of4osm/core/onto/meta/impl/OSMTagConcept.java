package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

/**
 *
 */
public abstract class OSMTagConcept extends OSMTagCombinationConceptParent implements IOSMTagConcept {

    public Set<IOSMTagConceptParent> parents;

    public OSMTagConcept() {
        this.parents = new HashSet<>();
    }
    
    public abstract IOSMTag getTag();

    @Override
    public Set<? extends IOSMTagConceptParent> getParents() {
        return parents;
    }

}
