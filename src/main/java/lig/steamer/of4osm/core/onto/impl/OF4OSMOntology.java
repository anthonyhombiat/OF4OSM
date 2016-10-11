/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.onto.impl;

import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

/**
 *
 * @author amehiris
 */
public class OF4OSMOntology implements IOF4OSMOntology {

    Set<IOSMCategoryTagKeyConcept> categoryTagKeyConcepts;
    Set<IOSMCategoryTagConcept> categoryTagConcepts;
    Set<IOSMTagCombinationConcept> tagCombinationConcepts;
    Set<IHighLevelConcept> highLevelConcepts;

    public OF4OSMOntology() {
        categoryTagKeyConcepts = new HashSet<>();
        categoryTagConcepts = new HashSet<>();
        tagCombinationConcepts = new HashSet<>();
        highLevelConcepts = new HashSet<>();
    }

    @Override
    public void addConcept(IConcept concept) {

        if (concept instanceof IOSMCategoryTagKeyConcept) {
            categoryTagKeyConcepts.add((IOSMCategoryTagKeyConcept) concept);
        }
        if (concept instanceof IOSMCategoryTagConcept) {
            categoryTagConcepts.add((IOSMCategoryTagConcept) concept);
        }
        if (concept instanceof IOSMTagCombinationConcept) {
            tagCombinationConcepts.add((IOSMTagCombinationConcept) concept);
        }
        if (concept instanceof IHighLevelConcept) {
            highLevelConcepts.add((IHighLevelConcept) concept);
        }

    }

	@Override
	public Set<IOSMTagCombinationConcept> getOSMTagCombinationConcepts() {
		return tagCombinationConcepts;
	}

	@Override
	public Set<IOSMCategoryTagKeyConcept> getOSMCategoryTagKeyConcepts() {
		return categoryTagKeyConcepts;
	}

	@Override
	public Set<IOSMCategoryTagConcept> getOSMCategoryTagConcepts() {
		return categoryTagConcepts;
	}
	
	@Override
	public Set<IHighLevelConcept> getHighLevelConcepts() {
		return highLevelConcepts;
	}

	@Override
    public String toString() {

    	String result = "";
    	
        for (IOSMCategoryTagKeyConcept entryKeyConcept : categoryTagKeyConcepts) {
           int i = 0;
           result += entryKeyConcept;

            for (IOSMCategoryTagConcept entryTagConcept : categoryTagConcepts) {

                for (IOSMTagConceptParent parent : entryTagConcept.getParents()) {

                    if (entryKeyConcept.getKey().equals((IOSMCategoryTagKeyConcept) parent)) {

                    	result += "|\t " + entryTagConcept;
                        
                        i++;
                    }
                }
            }
            result += "|--> nbr de fils  " + i;
        }
        
        for (IOSMTagCombinationConcept tag : tagCombinationConcepts) {
        	result += tag;
        }
        
        return result;
	}
	
}
