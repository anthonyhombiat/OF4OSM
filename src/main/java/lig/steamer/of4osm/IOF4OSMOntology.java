/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void addConcept(IConcept concept);
    
    public Set<IOSMTagCombinationConcept> getOSMTagCombinationConcepts();
    public Set<IOSMCategoryTagKeyConcept> getOSMCategoryTagKeyConcepts();
    public Set<IOSMCategoryTagConcept> getOSMCategoryTagConcepts();
    public Set<IHighLevelConcept> getHighLevelConcepts();
    
}
