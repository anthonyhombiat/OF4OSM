package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class HighLevelConcept extends Concept implements IHighLevelConcept, IHighLevelConceptParent, IOSMTagConceptParent {

	public String description;
    public Set<IHighLevelConceptParent> parents;
	
    public HighLevelConcept(String label) {
    	super(label);
    	parents = new HashSet<>();
    }

    @Override
    public Set<IHighLevelConceptParent> getParents() {
        return parents;
    }
    
    @Override
    public String getDescription() {
        return description;
    }

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void addParent(IHighLevelConceptParent parent) {
		parents.add(parent);
	}

}