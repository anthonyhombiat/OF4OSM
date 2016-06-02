package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagKey;

/**
 * 
 */
public interface IOSMTagKeyConcept extends IOSMTagConceptParent {

    /**
     * @return
     */
    public Set<IHighLevelConcept> getParents();

    /**
     * @return
     */
    public IOSMTagKey getKey();

}