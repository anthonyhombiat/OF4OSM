package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

/**
 * 
 */
public interface IHighLevelConcept extends IConcept {

	@Override
    public Set<IHighLevelConceptParent> getParents();

    /**
     * @return
     */
    public String getDescription();
    
    /**
     * 
     * @param parent
     */
    public void addParent(IHighLevelConceptParent parent);
}