package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;

import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMTagCombinationConcept extends Concept implements IOSMTagCombinationConcept, IOSMTagCombinationConceptParent {

    private Set<IOSMTagCombinationConceptParent> parents;

    public OSMTagCombinationConcept(IRI iri, Set<IOSMTagCombinationConceptParent> parents) {
    	super(iri);
    	this.parents = parents;
    }

    @Override
    public Set<IOSMTagCombinationConceptParent> getParents() {
        return parents;
    }

    @Override
    public void addParent(IOSMTagCombinationConceptParent parent) {
        parents.add(parent);
    }
 
    @Override
	public boolean isSubClassOf(IOSMTagCombinationConcept concept) {
		if(parents.size() > concept.getParents().size())
			return parents.containsAll(concept.getParents());
		return false;
	}
    
}
