package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

import org.semanticweb.owlapi.model.IRI;

/**
 *
 * @author amehiris
 */
public class OSMCategoryTagKeyConcept extends Concept implements IOSMCategoryTagKeyConcept, IHighLevelConceptParent, IOSMTagConceptParent {

    public Set<IHighLevelConcept> parents;
    public IOSMTagKey key;

    public OSMCategoryTagKeyConcept(IRI iri, IOSMTagKey key) {
    	super(iri);
    	this.key = key;
    	parents = new HashSet<>();
    }

    @Override
    public Set<IHighLevelConcept> getParents() {
        return parents;
    }
    
    @Override
    public void addParent(IHighLevelConcept parent){
    	parents.add(parent);
    }

    @Override
    public IOSMTagKey getKey() {
        return key;
    }
    
}
