package lig.steamer.of4osm.onto.meta;

import java.util.Set;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagKey;

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