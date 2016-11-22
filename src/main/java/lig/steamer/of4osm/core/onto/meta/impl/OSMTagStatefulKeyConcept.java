package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConceptParent;

import org.semanticweb.owlapi.model.IRI;

public class OSMTagStatefulKeyConcept extends OSMTagKeyConcept 
	implements IOSMTagStatefulKeyConcept,
		IOSMStatefulTagConceptParent {

	private IOSMTagStatefulKey key;
	private Set<IOSMTagStatefulKeyConceptParent> parents;
	
	public OSMTagStatefulKeyConcept(IRI iri, IOSMTagStatefulKey key) {
		super(iri);
		this.key = key;
		parents = new HashSet<>();
	}
	
	@Override
	public IOSMTagStatefulKey getKey() {
		return key;
	}
	
	@Override
	public Set<IOSMTagStatefulKeyConceptParent> getParents(){
		return parents;
	}
	
	@Override
	public void addParent(IOSMTagStatefulKeyConceptParent parent){
		parents.add(parent);
	}
	
}
