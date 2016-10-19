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
	 * Returns all the concepts of the ontology
	 * @return Set<IConcept>, the set of all the concepts of the ontology
	 */
	public Set<IConcept> getConcepts();
	
    /**
     * Adds a concept to the ontology
     * @return boolean, true if the insertion worked, false otherwise
     * @param concept, the concept to add
     */
	public boolean addConcept(IConcept concept);
    
	/**
	 * Returns all the IOSMTagCombinationConcept of the ontology
	 * @return Set<IOSMTagCombinationConcept>, the set of all the IOSMTagCombinationConcept of the ontology
	 */
    public Set<IOSMTagCombinationConcept> getOSMTagCombinationConcepts();
    
    /**
	 * Returns all the IOSMCategoryTagKeyConcept of the ontology
	 * @return Set<IOSMCategoryTagKeyConcept>, the set of all the IOSMCategoryTagKeyConcept of the ontology
	 */
    public Set<IOSMCategoryTagKeyConcept> getOSMCategoryTagKeyConcepts();
    
    /**
	 * Returns all the IOSMCategoryTagConcept of the ontology
	 * @return Set<IOSMCategoryTagConcept>, the set of all the IOSMCategoryTagConcept of the ontology
	 */
    public Set<IOSMCategoryTagConcept> getOSMCategoryTagConcepts();
    
    /**
	 * Returns all the IHighLevelConcept of the ontology
	 * @return Set<IHighLevelConcept>, the set of all the IHighLevelConcept of the ontology
	 */
    public Set<IHighLevelConcept> getHighLevelConcepts();
    
}
