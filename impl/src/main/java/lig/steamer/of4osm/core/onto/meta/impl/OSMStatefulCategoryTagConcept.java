package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulTagConceptParent;

import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMStatefulCategoryTagConcept extends OSMStatefulTagConcept implements IOSMStatefulCategoryTagConcept {

	private IOSMStatefulCategoryTag tag;

	public OSMStatefulCategoryTagConcept(IRI iri, IOSMStatefulCategoryTag tag, IOSMStatefulTagConceptParent parent) {
		super(iri);
		this.tag = tag;
		parents.add(parent);
	}

	@Override
	public IOSMStatefulCategoryTag getTag() {
		return tag;
	}

}
