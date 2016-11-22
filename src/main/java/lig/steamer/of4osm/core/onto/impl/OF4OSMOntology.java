package lig.steamer.of4osm.core.onto.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.onto.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;

/**
 *
 * @author amehiris
 */
public class OF4OSMOntology implements IOF4OSMOntology {

    Set<IOSMTagSimpleKeyConcept> categoryTagKeyConcepts;
    Set<IOSMSimpleCategoryTagConcept> categoryTagConcepts;
    Set<IOSMTagCombinationConcept> tagCombinationConcepts;
    Set<IHighLevelConcept> highLevelConcepts;

    public OF4OSMOntology() {
        categoryTagKeyConcepts = new HashSet<>();
        categoryTagConcepts = new HashSet<>();
        tagCombinationConcepts = new HashSet<>();
        highLevelConcepts = new HashSet<>();
    }

    @Override
    public boolean addConcept(IConcept concept) {

        if (concept instanceof IOSMTagSimpleKeyConcept) {
           return categoryTagKeyConcepts.add((IOSMTagSimpleKeyConcept) concept);
        }
        if (concept instanceof IOSMSimpleCategoryTagConcept) {
        	return categoryTagConcepts.add((IOSMSimpleCategoryTagConcept) concept);
        }
        if (concept instanceof IOSMTagCombinationConcept) {
        	return tagCombinationConcepts.add((IOSMTagCombinationConcept) concept);
        }
        if (concept instanceof IHighLevelConcept) {
        	return highLevelConcepts.add((IHighLevelConcept) concept);
        }
        
        return false;

    }

	@Override
	public Set<IOSMTagCombinationConcept> getOSMTagCombinationConcepts() {
		return tagCombinationConcepts;
	}

	@Override
	public Set<IOSMTagSimpleKeyConcept> getOSMCategoryTagKeyConcepts() {
		return categoryTagKeyConcepts;
	}

	@Override
	public Set<IOSMSimpleCategoryTagConcept> getOSMCategoryTagConcepts() {
		return categoryTagConcepts;
	}
	
	@Override
	public Set<IHighLevelConcept> getHighLevelConcepts() {
		return highLevelConcepts;
	}

	@Override
	public Set<IConcept> getConcepts() {
		Set<IConcept> concepts = new HashSet<>();
		concepts.addAll(categoryTagKeyConcepts);
		concepts.addAll(categoryTagConcepts);
		concepts.addAll(tagCombinationConcepts);
		concepts.addAll(highLevelConcepts);
		return concepts;
	}
	
}
