package lig.steamer.of4osm.parse;

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
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

/**
 *
 * @author amehiris
 */
public class OF4OSMFolkso2OntoParserTest extends TestCase {
    
    public OF4OSMFolkso2OntoParserTest(String testName) {
        super(testName);
    }

    /**
     * Test of combinations method, of class Folkso2OntoParser.
     */
    public void testCombinations() {
       
        IOSMTagSimpleKey key1 = new OSMTagSimpleKey("historic", "");
        IOSMTagStringValue value1 = new OSMTagStringValue("castle");
        IOSMCategoryTag tag1 = new OSMSimpleCategoryTag(key1, value1);
        IOSMCategoryTagKeyConcept keyConcept1 = OF4OSMFolkso2OntoParser.createCategoryTagKeyConcept(tag1);
        IOSMCategoryTagConcept concept1 = OF4OSMFolkso2OntoParser.createCategoryTagConcept(tag1, (IOSMTagConceptParent) keyConcept1);

        IOSMTagSimpleKey key2 = new OSMTagSimpleKey("amenity", "");
        IOSMTagStringValue value2 = new OSMTagStringValue("restaurant");
        IOSMCategoryTag tag2 = new OSMSimpleCategoryTag(key2, value2);
        IOSMCategoryTagKeyConcept keyConcept2 = OF4OSMFolkso2OntoParser.createCategoryTagKeyConcept(tag2);
        IOSMCategoryTagConcept concept2 = OF4OSMFolkso2OntoParser.createCategoryTagConcept(tag2, (IOSMTagConceptParent) keyConcept2);

        IOSMTagSimpleKey key3 = new OSMTagSimpleKey("tourism", "");
        IOSMTagStringValue value3 = new OSMTagStringValue("hotel");
        IOSMCategoryTag tag3 = new OSMSimpleCategoryTag(key3, value3);
        IOSMCategoryTagKeyConcept keyConcept3 = OF4OSMFolkso2OntoParser.createCategoryTagKeyConcept(tag3);
        IOSMCategoryTagConcept concept3 = OF4OSMFolkso2OntoParser.createCategoryTagConcept(tag3, (IOSMTagConceptParent) keyConcept3);

        IOSMTagSimpleKey key4 = new OSMTagSimpleKey("amenity", "");
        IOSMTagStringValue value4 = new OSMTagStringValue("bar");
        IOSMCategoryTag tag4 = new OSMSimpleCategoryTag(key4, value4);
        IOSMCategoryTagKeyConcept keyConcept4 = OF4OSMFolkso2OntoParser.createCategoryTagKeyConcept(tag4);
        IOSMCategoryTagConcept concept4 = OF4OSMFolkso2OntoParser.createCategoryTagConcept(tag4, (IOSMTagConceptParent) keyConcept4);
        
        IOSMTagCombinationConceptParent[] tagCombinationParents = new IOSMTagCombinationConceptParent[4];
        tagCombinationParents[0] = (IOSMTagCombinationConceptParent) concept1;
        tagCombinationParents[1] = (IOSMTagCombinationConceptParent) concept2;
        tagCombinationParents[2] = (IOSMTagCombinationConceptParent) concept3;
        tagCombinationParents[3] = (IOSMTagCombinationConceptParent) concept4;

        IOF4OSMOntology onto = new OF4OSMOntology();
        OF4OSMFolkso2OntoParser.addOSMTagCombinationsConcepts(tagCombinationParents, onto);
        
        System.out.println("tag combination concepts:");
        for(IOSMTagCombinationConcept tagCombiConcept : onto.getOSMTagCombinationConcepts()){
        	System.out.println("\r" + tagCombiConcept.getDefaultLabel());
        	for(IOSMTagCombinationConceptParent parent : tagCombiConcept.getParents()){
        		System.out.println("- " + parent.getDefaultLabel());
        	}
        }
    }
    
}
