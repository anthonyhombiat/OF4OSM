package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.onto.meta.IOSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;

import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMSimpleCategoryTagConcept extends OSMStatelessTagConcept implements IOSMSimpleCategoryTagConcept {

    public IOSMSimpleCategoryTag tag;

    public OSMSimpleCategoryTagConcept(IRI iri, IOSMSimpleCategoryTag tag, IOSMStatelessTagConceptParent parent) {
    	super(iri);
    	this.tag = tag;
        parents.add(parent);
    }

    @Override
    public IOSMSimpleCategoryTag getTag() {
        return tag;
    }

}
