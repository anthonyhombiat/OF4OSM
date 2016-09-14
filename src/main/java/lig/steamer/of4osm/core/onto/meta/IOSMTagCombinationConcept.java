package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;


/**
 * 
 */
public interface IOSMTagCombinationConcept extends IOSMTagCombinationConceptParent {

    /**
     * @return
     */
    public Set<? extends IOSMTagCombinationConceptParent> getParents();

    /**
     * @return
     */
    public IOSMTagConcept getTagConcepts();

}