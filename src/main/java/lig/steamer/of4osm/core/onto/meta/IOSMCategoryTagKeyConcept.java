package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;

/**
 * 
 */
public interface IOSMCategoryTagKeyConcept extends IConcept {

    /**
     * @return
     */
    @Override
    public Set<IHighLevelConcept> getParents();
    
    /**
     * 
     * @param parent
     */
    public void addParent(IHighLevelConcept parent);

    /**
     * @return
     */
    public IOSMTagKey getKey();

}