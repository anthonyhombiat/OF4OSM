package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;

/**
 * 
 */
public interface IOSMTagConcept extends IConcept {

    /**
     * @return
     */
    public Set<IOSMTagConceptParent> getParents();
    
    /**
     * 
     * @param parent
     */
    public void addParent(IOSMTagConceptParent parent);

    /**
     * @return
     */
    public IOSMTag getTag();

}