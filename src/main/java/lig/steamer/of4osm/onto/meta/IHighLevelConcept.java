package lig.steamer.of4osm.onto.meta;

import java.util.Set;

/**
 * 
 */
public interface IHighLevelConcept extends IOSMTagConceptParent {

    /**
     * @return
     */
    public Set<? extends IHighLevelConcept> getParents();

    /**
     * @return
     */
    public String getDescription();

}