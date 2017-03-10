package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.onto.meta.IOSMTagKeyConcept;

import org.semanticweb.owlapi.model.IRI;

public abstract class OSMTagKeyConcept extends Concept implements IOSMTagKeyConcept {

	public OSMTagKeyConcept(IRI iri){
		super(iri);
	}
	
	public abstract IOSMTagKey getKey();
	
}
