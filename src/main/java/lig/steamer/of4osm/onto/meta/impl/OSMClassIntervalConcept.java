package lig.steamer.of4osm.onto.meta.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagKey;
import lig.steamer.of4osm.onto.meta.DiscretizationMethod;
import lig.steamer.of4osm.onto.meta.IOSMClassIntervalConcept;

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