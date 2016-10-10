package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMNumericValuePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMNumericPropertyTagConcept;

/**
 * 
 */
public class OSMDiscretizedOSMNumericPropertyTagConcept extends OSMDiscretizedOSMPropertyTagConcept implements IOSMDiscretizedOSMNumericPropertyTagConcept {

	public IOSMNumericValuePropertyTag tag;
	public Double binf;
	public Double bsup;
	    
    public OSMDiscretizedOSMNumericPropertyTagConcept() {
    }

    /**
     * @return
     */
    public Double getBinf() {
        return binf;
    }

    /**
     * @return
     */
    public Double getBsup() {
       return bsup;
    }

    /**
     * @return
     */
    public IOSMNumericValuePropertyTag getTag() {
        return tag;
    }

}