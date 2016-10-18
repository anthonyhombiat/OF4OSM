package lig.steamer.of4osm;

import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;

/**
 *
 * @author amehiris
 */
public interface IOF4OSMOntology {
    
	/**
	 * 
	 * @return
	 */
	public Set<IConcept> getConcepts();
	
    /**
     * 
     * @param concept
     */
	public void addConcept(IConcept concept);
    
	/**
	 * 
	 * @return
	 */
    public Set<IOSMTagCombinationConcept> getOSMTagCombinationConcepts();
    
    /**
     * 
     * @return
     */
    public Set<IOSMCategoryTagKeyConcept> getOSMCategoryTagKeyConcepts();
    
    /**
     * 
     * @return
     */
    public Set<IOSMCategoryTagConcept> getOSMCategoryTagConcepts();
    
    /**
     * 
     * @return
     */
    public Set<IHighLevelConcept> getHighLevelConcepts();
    
}
