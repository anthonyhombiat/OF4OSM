package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.onto.meta.DiscretizationMethod;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMPropertyTagConcept;

/**
 * 
 */
public abstract class OSMDiscretizedOSMPropertyTagConcept extends OSMPropertyTagConcept implements IOSMDiscretizedOSMPropertyTagConcept {

    /**
     * 
     */
    public DiscretizationMethod discretizationMethod;


    /**
     * @return
     */
    public DiscretizationMethod getDiscretizationMethod() {
        // TODO implement here
        return null;
    }

}