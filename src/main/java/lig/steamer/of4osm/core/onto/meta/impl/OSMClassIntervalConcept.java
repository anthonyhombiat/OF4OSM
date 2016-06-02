package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagKey;
import lig.steamer.of4osm.core.onto.meta.DiscretizationMethod;
import lig.steamer.of4osm.core.onto.meta.IOSMClassIntervalConcept;

/**
 * 
 */
public abstract class OSMClassIntervalConcept extends OSMTagKeyConcept implements IOSMClassIntervalConcept {

    /**
     * Default constructor
     */
    public OSMClassIntervalConcept() {
    }

    /**
     * 
     */
    public DiscretizationMethod discretizationMethod;

    /**
     * @return
     */
    public abstract IOSMTagKey getKey();

    /**
     * @return
     */
    public DiscretizationMethod getDiscretizationMethod() {
        // TODO implement here
        return null;
    }

}