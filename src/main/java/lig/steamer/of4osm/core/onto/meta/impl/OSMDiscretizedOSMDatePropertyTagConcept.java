package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Date;

import lig.steamer.of4osm.core.folkso.tag.IOSMDateValuePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMDatePropertyTagConcept;

import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMDiscretizedOSMDatePropertyTagConcept extends OSMDiscretizedOSMPropertyTagConcept implements IOSMDiscretizedOSMDatePropertyTagConcept {

	public IOSMDateValuePropertyTag tag;
    public Date binf;
    public Date bsup;
    
    public OSMDiscretizedOSMDatePropertyTagConcept(IRI iri) {
		super(iri);
	}

    @Override
    public Date getBinf() {
        return binf;
    }

    @Override
    public Date getBsup() {
        return bsup;
    }

    @Override
    public IOSMDateValuePropertyTag getTag() {
       return tag;
    }

}