package lig.steamer.of4osm.onto.meta;

import java.util.Set;

import lig.steamer.of4osm.folkso.tag.component.IOSMTag;

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