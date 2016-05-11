package lig.steamer.of4osm.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.folkso.tag.typology.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.onto.meta.IOSMTagConceptParent;

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