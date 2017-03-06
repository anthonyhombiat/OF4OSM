package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.onto.meta.DiscretizationMethod;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMPropertyTagConcept;

import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public abstract class OSMDiscretizedOSMPropertyTagConcept extends OSMPropertyTagConcept implements IOSMDiscretizedOSMPropertyTagConcept {

	public DiscretizationMethod discretizationMethod;
	
    public OSMDiscretizedOSMPropertyTagConcept(IRI iri) {
		super(iri);
	}

    /**
     * @return
     */
    public DiscretizationMethod getDiscretizationMethod() {
        return discretizationMethod;
    }

}