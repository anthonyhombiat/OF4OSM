package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.onto.meta.DiscretizationMethod;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMPropertyTagConcept;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public abstract class OSMDiscretizedOSMPropertyTagConcept extends OSMPropertyTagConcept implements IOSMDiscretizedOSMPropertyTagConcept {

    public OSMDiscretizedOSMPropertyTagConcept(String label) {
		super(label);
	}

	public DiscretizationMethod discretizationMethod;

    /**
     * @return
     */
    public DiscretizationMethod getDiscretizationMethod() {
        return discretizationMethod;
    }

}