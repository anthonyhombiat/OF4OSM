package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

/**
 * 
 */
public interface IHighLevelConcept extends IOSMTagConceptParent {

    /**
     * @return
     */
    public Set<? extends IHighLevelConceptParent> getParents();

    /**
     * @return
     */
    public String getDescription();

}