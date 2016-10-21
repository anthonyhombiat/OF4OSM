package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

import org.semanticweb.owlapi.model.IRI;

/**
 *
 */
public abstract class OSMTagConcept extends Concept implements IOSMTagConcept, IOSMTagCombinationConceptParent {

    public Set<IOSMTagConceptParent> parents;

    public OSMTagConcept(IRI iri) {
    	super(iri);
        parents = new HashSet<>();
    }
    
    public abstract IOSMTag getTag();

    @Override
    public Set<IOSMTagConceptParent> getParents() {
        return parents;
    }
    
    @Override
    public void addParent(IOSMTagConceptParent parent){
    	parents.add(parent);
    }

}
