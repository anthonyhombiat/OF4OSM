package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.typology.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

/**
 * 
 */
public class OSMCategoryTagConcept extends OSMTagConcept implements IOSMCategoryTagConcept {

    /**
     * Default constructor
     */
    public OSMCategoryTagConcept() {
    }

    /**
     * 
     */
    public IOSMSimpleCategoryTag tag;

    /**
     * @return
     */
    public IOSMSimpleCategoryTag getTag() {
        // TODO implement here
        return null;
    }

	@Override
	public Set<? extends IOSMTagConceptParent> getParents() {
		// TODO Auto-generated method stub
		return null;
	}

}