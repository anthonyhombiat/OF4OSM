package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConceptParent;

import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class HighLevelConcept extends Concept 
	implements IHighLevelConcept, 
		IHighLevelConceptParent,
		IOSMTagStatefulKeyConceptParent, 
		IOSMStatelessTagConceptParent,
		IOSMStatefulTagConceptParent,
		IOSMTagCombinationConceptParent {

	public String description;
    public Set<IHighLevelConceptParent> parents;
	
    public HighLevelConcept(IRI iri) {
    	super(iri);
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