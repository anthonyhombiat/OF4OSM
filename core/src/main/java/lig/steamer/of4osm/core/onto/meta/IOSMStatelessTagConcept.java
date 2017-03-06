package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

public interface IOSMStatelessTagConcept extends IOSMTagConcept {

    @Override
    public Set<IOSMStatelessTagConceptParent> getParents();
    
    /**
     * 
     * @param parent
     */
    public void addParent(IOSMStatelessTagConceptParent parent);
	
}
