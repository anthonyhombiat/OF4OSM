package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMTagSimpleKeyConcept extends IOSMTagKeyConcept {

    @Override
    public Set<IHighLevelConceptParent> getParents();
    
    /**
     * 
     * @param parent
     */
    public void addParent(IHighLevelConceptParent parent);

    @Override
    public IOSMTagSimpleKey getKey();

}