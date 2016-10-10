package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConceptParent;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class HighLevelConcept extends Concept implements IHighLevelConcept, IHighLevelConceptParent {

	public String description;
    public Set<IHighLevelConceptParent> parents;
	
    public HighLevelConcept(String label) {
    	super.addLabel("EN", label);
    }

    public Set<? extends IHighLevelConceptParent> getParents() {
        return parents;
    }
    
    public String getDescription() {
        return description;
    }

	public void setDescription(String description) {
		this.description = description;
	}

}