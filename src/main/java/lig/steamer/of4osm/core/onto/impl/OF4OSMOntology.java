/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.onto.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

/**
 *
 * @author amehiris
 */
public class OF4OSMOntology implements IOF4OSMOntology {

    Map<IOSMCategoryTagKeyConcept, Integer> tagKeyConceptMap;
    Map<IOSMCategoryTagConcept, Integer> categoryTagConceptMap;

    Set<IOSMTagCombinationConcept> tagCombinationConceptSet;

    public OF4OSMOntology() {
        this.tagKeyConceptMap = new HashMap<>();
        this.categoryTagConceptMap = new HashMap<>();
        this.tagCombinationConceptSet = new HashSet<>();
    }

    @Override
    public void addConcept(IConcept concept, int nbInstances) {

        if (IOSMCategoryTagKeyConcept.class.isInstance(concept)) {
            this.tagKeyConceptMap.put((IOSMCategoryTagKeyConcept) concept, nbInstances);
        }
        if (IOSMCategoryTagConcept.class.isInstance(concept)) {
            this.categoryTagConceptMap.put((IOSMCategoryTagConcept) concept, nbInstances);
        }
        if (IOSMTagCombinationConcept.class.isInstance(concept)) {
            this.tagCombinationConceptSet.add((IOSMTagCombinationConcept) concept);
        }

    }

    @Override
    public void afficher() {

        for (Map.Entry<IOSMCategoryTagKeyConcept, Integer> entryKeyConcept : tagKeyConceptMap.entrySet()) {
            int i = 0;
            int nb = 0;
            System.out.println(entryKeyConcept.getKey());

            for (Map.Entry<IOSMCategoryTagConcept, Integer> entryTagConcept : categoryTagConceptMap.entrySet()) {

                for (IOSMTagConceptParent parent : entryTagConcept.getKey().getParents()) {

                    if (entryKeyConcept.getKey().equals((IOSMCategoryTagKeyConcept) parent)) {

                        System.out.println("|\t" + entryTagConcept.getValue() + " : " + entryTagConcept.getKey());
                        i++;
                        nb = nb + entryTagConcept.getValue();

                    }
                }
            }
            System.out.println("|--> nbr de fils  " + i);
            System.out.println("|--> nbr d'instance  " + nb + "\n");
        }
//        for (IOSMTagCombinationConcept tag : tagCombinationConceptSet) {
//            System.out.println(tag);
//        }

    }

}
