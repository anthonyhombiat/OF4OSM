package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;


/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMStatefulTagConcept extends IOSMTagConcept {

    @Override
    public Set<IOSMStatefulTagConceptParent> getParents();
    
    /**
     * 
     * @param parent
     */
    public void addParent(IOSMStatefulTagConceptParent parent);
	
}
