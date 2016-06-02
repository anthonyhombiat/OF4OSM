package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTag;

/**
 * 
 */
public interface IOSMTagConcept extends IAristotelianConceptParent {

    /**
     * @return
     */
    public Set<? extends IOSMTagConceptParent> getParents();

    /**
     * @return
     */
    public IOSMTag getTag();

}