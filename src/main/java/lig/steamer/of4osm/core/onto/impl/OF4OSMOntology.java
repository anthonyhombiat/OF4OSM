package lig.steamer.of4osm.core.onto.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.onto.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMBooleanPropertyTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;

/**
 *
 * @author amehiris
 */
public class OF4OSMOntology implements IOF4OSMOntology {

    Set<IOSMTagSimpleKeyConcept> tagSimpleKeyConcepts;
    Set<IOSMTagStatefulKeyConcept> tagStatefulKeyConcepts;
    
    Set<IOSMSimpleCategoryTagConcept> simpleCategoryTagConcepts;
    Set<IOSMStatefulCategoryTagConcept> statefulCategoryTagConcepts;
    Set<IOSMTagCombinationConcept> tagCombinationConcepts;
    Set<IHighLevelConcept> highLevelConcepts;
    Set<IOSMBooleanPropertyTagConcept> booleanPropertyTagConcepts;

    public OF4OSMOntology() {
        tagSimpleKeyConcepts = new HashSet<>();
        tagStatefulKeyConcepts = new HashSet<>();
        simpleCategoryTagConcepts = new HashSet<>();
        statefulCategoryTagConcepts = new HashSet<>();
        tagCombinationConcepts = new HashSet<>();
        highLevelConcepts = new HashSet<>();
        booleanPropertyTagConcepts = new HashSet<>();
    }

    @Override
    public boolean addConcept(IConcept concept) {

        if (concept instanceof IOSMTagSimpleKeyConcept)
           return tagSimpleKeyConcepts.add((IOSMTagSimpleKeyConcept) concept);
        if (concept instanceof IOSMTagStatefulKeyConcept)
            return tagStatefulKeyConcepts.add((IOSMTagStatefulKeyConcept) concept);
        if (concept instanceof IOSMSimpleCategoryTagConcept)
        	return simpleCategoryTagConcepts.add((IOSMSimpleCategoryTagConcept) concept);
        if (concept instanceof IOSMStatefulCategoryTagConcept)
        	return statefulCategoryTagConcepts.add((IOSMStatefulCategoryTagConcept) concept);
        if (concept instanceof IOSMTagCombinationConcept)
        	return tagCombinationConcepts.add((IOSMTagCombinationConcept) concept);
        if (concept instanceof IHighLevelConcept)
        	return highLevelConcepts.add((IHighLevelConcept) concept);
        if (concept instanceof IOSMBooleanPropertyTagConcept)
        	return booleanPropertyTagConcepts.add((IOSMBooleanPropertyTagConcept) concept);
        
        return false;
    }
    
    @Override
	public Set<IHighLevelConcept> getHighLevelConcepts() {
		return highLevelConcepts;
	}

    @Override
	public Set<IOSMTagStatefulKeyConcept> getOSMTagStatefulKeyConcepts() {
		return tagStatefulKeyConcepts;
	}
    
	@Override
	public Set<IOSMTagSimpleKeyConcept> getOSMTagSimpleKeyConcepts() {
		return tagSimpleKeyConcepts;
	}

	@Override
	public Set<IOSMSimpleCategoryTagConcept> getOSMSimpleCategoryTagConcepts() {
		return simpleCategoryTagConcepts;
	}
	
	@Override
	public Set<IOSMStatefulCategoryTagConcept> getOSMStatefulCategoryTagConcepts() {
		return statefulCategoryTagConcepts;
	}
	
	@Override
	public Set<IOSMTagCombinationConcept> getOSMTagCombinationConcepts() {
		return tagCombinationConcepts;
	}
	
	@Override
	public Set<IOSMBooleanPropertyTagConcept> getOSMBooleanPropertyTagConcepts() {
		return booleanPropertyTagConcepts;
	}

	@Override
	public Set<IConcept> getConcepts() {
		Set<IConcept> concepts = new HashSet<>();
		concepts.addAll(tagSimpleKeyConcepts);
		concepts.addAll(tagStatefulKeyConcepts);
		concepts.addAll(simpleCategoryTagConcepts);
		concepts.addAll(statefulCategoryTagConcepts);
		concepts.addAll(tagCombinationConcepts);
		concepts.addAll(highLevelConcepts);
		concepts.addAll(booleanPropertyTagConcepts);
		return concepts;
	}
	
}