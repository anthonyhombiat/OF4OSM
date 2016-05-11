package lig.steamer.of4osm.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagKey;
import lig.steamer.of4osm.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.onto.meta.IOSMTagKeyConcept;

/**
 * 
 */
public abstract class OSMTagKeyConcept extends Concept implements IOSMTagKeyConcept {

    /**
     * Default constructor
     */
    public OSMTagKeyConcept() {
    }

    /**
     * 
     */
    public Set<IHighLevelConcept> parents;

    /**
     * @return
     */
    public abstract IOSMTagKey getKey();

    /**
     * @return
     */
    public Set<IHighLevelConcept> getParents() {
        // TODO implement here
        return null;
    }

}