package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMBooleanValuePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMBooleanPropertyTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

/**
 * 
 */
public class OSMBooleanPropertyTagConcept extends OSMTagConcept implements IOSMBooleanPropertyTagConcept {

	public IOSMBooleanValuePropertyTag tag;
	 
    public OSMBooleanPropertyTagConcept() {
    }

    /**
     * @return
     */
    public IOSMBooleanValuePropertyTag getTag() {
       return tag;
    }

	@Override
	public Set<? extends IOSMTagConceptParent> getParents() {
		// TODO Auto-generated method stub
		return null;
	}

}