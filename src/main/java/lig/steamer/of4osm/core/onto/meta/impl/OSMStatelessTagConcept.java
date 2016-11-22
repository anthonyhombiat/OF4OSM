package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IOSMStatefulTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;

import org.semanticweb.owlapi.model.IRI;

public abstract class OSMStatelessTagConcept extends OSMTagConcept 
	implements IOSMStatelessTagConcept,
		IOSMStatefulTagConceptParent,
		IOSMTagCombinationConceptParent {

	public OSMStatelessTagConcept(IRI iri) {
		super(iri);
		parents = new HashSet<>();
	}

	public Set<IOSMStatelessTagConceptParent> parents;
	
	@Override
    public Set<IOSMStatelessTagConceptParent> getParents() {
        return parents;
    }
    
    @Override
    public void addParent(IOSMStatelessTagConceptParent parent){
    	parents.add(parent);
    }
	
}
