package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IOSMStatefulTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;

import org.semanticweb.owlapi.model.IRI;


public abstract class OSMStatefulTagConcept extends OSMTagConcept 
	implements IOSMStatefulTagConcept, 
		IOSMTagCombinationConceptParent {

	public OSMStatefulTagConcept(IRI iri) {
		super(iri);
		parents = new HashSet<>();
	}

	public Set<IOSMStatefulTagConceptParent> parents;
	
	@Override
    public Set<IOSMStatefulTagConceptParent> getParents() {
        return parents;
    }
    
    @Override
    public void addParent(IOSMStatefulTagConceptParent parent){
    	parents.add(parent);
    }
	
}
