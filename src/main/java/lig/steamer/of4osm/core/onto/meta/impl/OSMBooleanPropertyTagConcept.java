package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.typology.IOSMBooleanSimpleValuePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMBooleanPropertyTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

/**
 * 
 */
public class OSMBooleanPropertyTagConcept extends OSMTagConcept implements IOSMBooleanPropertyTagConcept {

    /**
     * Default constructor
     */
    public OSMBooleanPropertyTagConcept() {
    }

    /**
     * 
     */
    public IOSMBooleanSimpleValuePropertyTag tag;

    /**
     * @return
     */
    public IOSMBooleanSimpleValuePropertyTag getTag() {
        // TODO implement here
        return null;
    }

	@Override
	public Set<? extends IOSMTagConceptParent> getParents() {
		// TODO Auto-generated method stub
		return null;
	}

}