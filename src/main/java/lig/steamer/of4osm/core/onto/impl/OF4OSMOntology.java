/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.onto.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMTag;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMTagKeyConcept;

/**
 *
 * @author amehiris
 */
public class OF4OSMOntology {

    Set<OSMTagKeyConcept> tagKeyConceptSet;
    Set<OSMCategoryTagConcept> categoryTagConceptSet;
    
    public OF4OSMOntology() {
        this.tagKeyConceptSet = new HashSet();
        this.categoryTagConceptSet = new HashSet();
    }

    public void addConceptSimpleCategory(Map<OSMSimpleCategoryTag, Integer> mapOSMTag) {

        for (Map.Entry<OSMSimpleCategoryTag, Integer> entry : mapOSMTag.entrySet()) {
            OSMTagKeyConcept tagKeyConcept = new OSMTagKeyConcept((OSMTagSimpleKey) entry.getKey().getKey());
            //Key
            tagKeyConceptSet.add(tagKeyConcept);

            //OSMTag 
            OSMCategoryTagConcept categoryTagConcept = new OSMCategoryTagConcept((OSMSimpleCategoryTag)entry.getKey(), (OSMTagKeyConcept)tagKeyConcept);
            categoryTagConceptSet.add(categoryTagConcept);
            
        }
    }
 
    public void afficher() {
        System.out.println(tagKeyConceptSet);
        System.out.println(categoryTagConceptSet);
    }

    public void addConcept(Map<OSMTag, Integer> mapOSMTag) {

    }
}
