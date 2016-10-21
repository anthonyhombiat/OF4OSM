package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMCategoryTagConcept extends OSMTagConcept implements IOSMCategoryTagConcept {

    public IOSMCategoryTag tag;

    public OSMCategoryTagConcept(IRI iri, IOSMCategoryTag tag, IOSMTagConceptParent parent) {
    	super(iri);
    	this.tag = tag;
        parents.add(parent);
    }

    @Override
    public IOSMCategoryTag getTag() {
        return tag;
    }

    @Override
    public Set<IOSMTagConceptParent> getParents() {
        return parents;
    }

}
