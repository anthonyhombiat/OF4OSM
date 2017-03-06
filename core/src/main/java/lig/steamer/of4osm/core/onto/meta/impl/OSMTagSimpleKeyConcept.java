package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConceptParent;

import org.semanticweb.owlapi.model.IRI;

/**
 *
 * @author amehiris
 */
public class OSMTagSimpleKeyConcept extends OSMTagKeyConcept 
	implements IOSMTagSimpleKeyConcept, 
		IHighLevelConceptParent, 
		IOSMTagStatefulKeyConceptParent,
		IOSMStatelessTagConceptParent {

    public Set<IHighLevelConceptParent> parents;
    public IOSMTagSimpleKey key;

    public OSMTagSimpleKeyConcept(IRI iri, IOSMTagSimpleKey key) {
    	super(iri);
    	this.key = key;
    	parents = new HashSet<>();
    }

    @Override
    public Set<IHighLevelConceptParent> getParents() {
        return parents;
    }
    
    @Override
    public void addParent(IHighLevelConceptParent parent){
    	parents.add(parent);
    }

    @Override
    public IOSMTagSimpleKey getKey() {
        return key;
    }
    
}
