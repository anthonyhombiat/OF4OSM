package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;

/**
 * 
 */
public interface IOSMCategoryTagKeyConcept extends IOSMTagConceptParent {

    /**
     * @return
     */
    @Override
    public Set<IHighLevelConcept> getParents();

    /**
     * @return
     */
    public IOSMTagKey getKey();

}