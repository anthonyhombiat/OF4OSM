package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;


/**
 * 
 */
public interface IAristotelianConcept extends IAristotelianConceptParent {

    /**
     * @return
     */
    public Set<? extends IAristotelianConceptParent> getParents();

    /**
     * @return
     */
    public IOSMTagConcept getTagConcepts();

}