/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.util;

import junit.framework.TestCase;
import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import static lig.steamer.of4osm.util.Folkso2OntoParser.combinations;

/**
 *
 * @author amehiris
 */
public class Folkso2OntoParserTest extends TestCase {
    
    public Folkso2OntoParserTest(String testName) {
        super(testName);
    }

    /**
     * Test of combinations method, of class Folkso2OntoParser.
     */
    public void testCombinations() {
       
       
        IOSMTagSimpleKey key1 = new OSMTagSimpleKey("historic", "");
        IOSMTagStringValue value1 = new OSMTagStringValue("castle");
        IOSMCategoryTag tag1 = new OSMSimpleCategoryTag(key1, value1);
        IOSMCategoryTagKeyConcept keyConcept1 = Folkso2OntoParser.createCategoryTagKeyConcept(tag1);
        IOSMCategoryTagConcept concept1 = Folkso2OntoParser.createCategoryTagConcept(tag1, keyConcept1);

        IOSMTagSimpleKey key2 = new OSMTagSimpleKey("amenity", "");
        IOSMTagStringValue value2 = new OSMTagStringValue("restaurant");
        IOSMCategoryTag tag2 = new OSMSimpleCategoryTag(key2, value2);
        IOSMCategoryTagKeyConcept keyConcept2 = Folkso2OntoParser.createCategoryTagKeyConcept(tag2);
        IOSMCategoryTagConcept concept2 = Folkso2OntoParser.createCategoryTagConcept(tag2, keyConcept2);

        IOSMTagSimpleKey key3 = new OSMTagSimpleKey("tourism", "");
        IOSMTagStringValue value3 = new OSMTagStringValue("hotel");
        IOSMCategoryTag tag3 = new OSMSimpleCategoryTag(key3, value3);
        IOSMCategoryTagKeyConcept keyConcept3 = Folkso2OntoParser.createCategoryTagKeyConcept(tag3);
        IOSMCategoryTagConcept concept3 = Folkso2OntoParser.createCategoryTagConcept(tag3, keyConcept3);

        IOSMCategoryTagConcept[] categoryTagConceptSet = new IOSMCategoryTagConcept[3];
        categoryTagConceptSet[0] = concept1;
        categoryTagConceptSet[1] = concept2;
        categoryTagConceptSet[2] = concept3;

        IOF4OSMOntology onto = new OF4OSMOntology();
        combinations(categoryTagConceptSet, 2, 0, new IOSMCategoryTagConcept[2], onto);
    }
    
}
