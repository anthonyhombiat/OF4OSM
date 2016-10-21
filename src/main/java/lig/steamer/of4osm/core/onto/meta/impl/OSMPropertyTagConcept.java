package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMPropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMPropertyTagConcept;

import org.semanticweb.owlapi.model.IRI;

/**
 *
 * @author amehiris
 */
public abstract class OSMPropertyTagConcept extends OSMTagConcept implements IOSMPropertyTagConcept {
	
	public OSMPropertyTagConcept(IRI iri) {
		super(iri);
	}

	@Override
    public abstract IOSMPropertyTag getTag();
	
}
