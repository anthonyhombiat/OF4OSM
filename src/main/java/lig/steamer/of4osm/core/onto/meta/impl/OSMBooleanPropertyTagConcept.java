package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMBooleanValuePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMBooleanPropertyTagConcept;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMBooleanPropertyTagConcept extends OSMTagConcept implements IOSMBooleanPropertyTagConcept {

	public IOSMBooleanValuePropertyTag tag;
	 
    public OSMBooleanPropertyTagConcept(String label) {
    	super(label);
    }

    /**
     * @return
     */
    public IOSMBooleanValuePropertyTag getTag() {
       return tag;
    }

}