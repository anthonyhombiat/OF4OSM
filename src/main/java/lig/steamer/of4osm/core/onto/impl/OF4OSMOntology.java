/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.onto.impl;

import java.util.HashSet;
import java.util.Set;
import lig.steamer.of4osm.core.onto.meta.IConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

/**
 *
 * @author amehiris
 */
public class OF4OSMOntology {

    Set<IOSMCategoryTagKeyConcept> tagKeyConceptSet;
    Set<IOSMCategoryTagConcept> categoryTagConceptSet;

    public OF4OSMOntology() {
        this.tagKeyConceptSet = new HashSet<>();
        this.categoryTagConceptSet = new HashSet<>();
    }

    public void addConcept(IConcept concept) {

        if (IOSMCategoryTagKeyConcept.class.isInstance(concept)) {
            this.tagKeyConceptSet.add((IOSMCategoryTagKeyConcept) concept);
        }
        if (IOSMCategoryTagConcept.class.isInstance(concept)) {
            this.categoryTagConceptSet.add((IOSMCategoryTagConcept) concept);
        }
    }

    public void afficher() {

        for (IOSMCategoryTagKeyConcept tagKeyConcept : tagKeyConceptSet) {
            System.out.println(tagKeyConcept);

            for (IOSMCategoryTagConcept tagConcept : categoryTagConceptSet) {
                
                for (IOSMTagConceptParent parent : tagConcept.getParents()) {
                    
                    if (tagKeyConcept.equals((IOSMCategoryTagKeyConcept)parent)) {
                        
                        System.out.println("\t"+tagConcept);
                    }
                }
            }
        }
        System.out.println(tagKeyConceptSet);
        System.out.println(categoryTagConceptSet);
    }

}
