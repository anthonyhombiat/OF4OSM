package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMBooleanValuePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMBooleanPropertyTagConcept;

import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMBooleanPropertyTagConcept extends OSMStatelessTagConcept implements IOSMBooleanPropertyTagConcept {

	public IOSMBooleanValuePropertyTag tag;
	 
    public OSMBooleanPropertyTagConcept(IRI iri) {
    	super(iri);
    }

    @Override
    public IOSMBooleanValuePropertyTag getTag() {
       return tag;
    }

}