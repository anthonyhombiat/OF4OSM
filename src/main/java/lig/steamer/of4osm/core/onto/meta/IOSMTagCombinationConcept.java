package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMTagCombinationConcept extends IConcept {

    @Override
    public Set<IOSMTagCombinationConceptParent> getParents();
    
    /**
     * 
     * @param parent
     */
    public void addParent(IOSMTagCombinationConceptParent parent);
    
    /**
     * 
     * @param concept
     * @return
     */
    public boolean isSubClassOf(IOSMTagCombinationConcept concept); 

}
