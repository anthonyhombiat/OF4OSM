package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Date;

import lig.steamer.of4osm.core.folkso.tag.IOSMDateValuePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMDatePropertyTagConcept;

import org.semanticweb.owlapi.model.IRI;

/**
 *
 * @author amehiris
 */
public class OSMDiscretizedOSMTimeDomainsPropertyTagConcept  extends OSMDiscretizedOSMPropertyTagConcept implements IOSMDiscretizedOSMDatePropertyTagConcept {

	public IOSMDateValuePropertyTag tag;
	
	public OSMDiscretizedOSMTimeDomainsPropertyTagConcept(IRI iri) {
		super(iri);
	}
	
	@Override
	public Date getBinf() {
		return null;
	}

	@Override
	public Date getBsup() {
		return null;
	}

	@Override
	public IOSMDateValuePropertyTag getTag() {
		return tag;
	}
    
}
