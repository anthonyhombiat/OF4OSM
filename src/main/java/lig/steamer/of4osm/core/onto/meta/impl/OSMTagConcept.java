package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConcept;

import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public abstract class OSMTagConcept extends Concept implements IOSMTagConcept, IOSMStatelessTagConceptParent, IOSMTagCombinationConceptParent {

    public OSMTagConcept(IRI iri) {
    	super(iri);
    }
    
    public abstract IOSMTag getTag();

}
