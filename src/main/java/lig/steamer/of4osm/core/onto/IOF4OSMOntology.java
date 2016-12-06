package lig.steamer.of4osm.core.onto;

import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConcept;
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
	 * Returns all the IHighLevelConcept of the ontology
	 * @return Set<IHighLevelConcept>, the set of all the IHighLevelConcept of the ontology
	 */
    public Set<IHighLevelConcept> getHighLevelConcepts();
	
    /**
	 * Returns all the IOSMTagSimpleKeyConcept of the ontology
	 * @return Set<IOSMTagSimpleKeyConcept>, the set of all the IOSMTagSimpleKeyConcept of the ontology
	 */
    public Set<IOSMTagSimpleKeyConcept> getOSMTagSimpleKeyConcepts();
    
    /**
	 * Returns all the IOSMTagStatefulKeyConcept of the ontology
	 * @return Set<IOSMTagStatefulKeyConcept>, the set of all the IOSMTagStatefulKeyConcept of the ontology
	 */
    public Set<IOSMTagStatefulKeyConcept> getOSMTagStatefulKeyConcepts();
    
    /**
	 * Returns all the IOSMCategoryTagConcept of the ontology
	 * @return Set<IOSMCategoryTagConcept>, the set of all the IOSMCategoryTagConcept of the ontology
	 */
    public Set<IOSMSimpleCategoryTagConcept> getOSMSimpleCategoryTagConcepts();
    
    /**
	 * Returns all the IOSMTagCombinationConcept of the ontology
	 * @return Set<IOSMTagCombinationConcept>, the set of all the IOSMTagCombinationConcept of the ontology
	 */
    public Set<IOSMTagCombinationConcept> getOSMTagCombinationConcepts();

    /**
	 * Returns all the IOSMStatefulCategoryTagConcept of the ontology
	 * @return Set<IOSMStatefulCategoryTagConcept>, the set of all the IOSMStatefulCategoryTagConcept of the ontology
	 */
    public Set<IOSMStatefulCategoryTagConcept> getOSMStatefulCategoryTagConcepts();
    
}
