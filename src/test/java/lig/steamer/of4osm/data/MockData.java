package lig.steamer.of4osm.data;


import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.IOF4OSMFolksonomy;
import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;
import lig.steamer.of4osm.util.OF4OSMConceptFactory;

public class MockData {
	
	public IOF4OSMFolksonomy folkso;
	public IOF4OSMOntology onto;
	
	public MockData(){
				
		final IOSMTagSimpleKey key1 = new OSMTagSimpleKey("historic", "");
    	final IOSMTagStringValue value1 = new OSMTagStringValue("castle");
    	final IOSMCategoryTag tag1 = new OSMSimpleCategoryTag(key1, value1);
    	
    	final IOSMTagSimpleKey key2 = new OSMTagSimpleKey("amenity", "");
    	final IOSMTagStringValue value2 = new OSMTagStringValue("restaurant");
    	final IOSMCategoryTag tag2 = new OSMSimpleCategoryTag(key2, value2);
    	
    	final IOSMTagSimpleKey key3 = new OSMTagSimpleKey("tourism", "");
        final IOSMTagStringValue value3 = new OSMTagStringValue("hotel");
        final IOSMCategoryTag tag3 = new OSMSimpleCategoryTag(key3, value3);
        
        final IOSMTagSimpleKey key4 = new OSMTagSimpleKey("amenity", "");
        final IOSMTagStringValue value4 = new OSMTagStringValue("bar");
        final IOSMCategoryTag tag4 = new OSMSimpleCategoryTag(key4, value4);
        
        Set<IOSMCategoryTag> tags = new HashSet<>();
        tags.add(tag1);
        tags.add(tag2);
        tags.add(tag3);
        tags.add(tag4);
        
        folkso = new OF4OSMFolksonomy();
        folkso.addTagsByElement("test", tags);
    	
    	final IOSMCategoryTagKeyConcept keyConcept1 = OF4OSMConceptFactory.createOSMCategoryTagKeyConcept(tag1.getKey());
    	final IOSMCategoryTagConcept concept1 = OF4OSMConceptFactory.createOSMCategoryTagConcept(tag1, (IOSMTagConceptParent) keyConcept1);

    	final IOSMCategoryTagKeyConcept keyConcept2 = OF4OSMConceptFactory.createOSMCategoryTagKeyConcept(tag2.getKey());
    	final IOSMCategoryTagConcept concept2 = OF4OSMConceptFactory.createOSMCategoryTagConcept(tag2, (IOSMTagConceptParent) keyConcept2);

        final IOSMCategoryTagKeyConcept keyConcept3 = OF4OSMConceptFactory.createOSMCategoryTagKeyConcept(tag3.getKey());
        final IOSMCategoryTagConcept concept3 = OF4OSMConceptFactory.createOSMCategoryTagConcept(tag3, (IOSMTagConceptParent) keyConcept3);

        final IOSMCategoryTagKeyConcept keyConcept4 = OF4OSMConceptFactory.createOSMCategoryTagKeyConcept(tag4.getKey());
        final IOSMCategoryTagConcept concept4 = OF4OSMConceptFactory.createOSMCategoryTagConcept(tag4, (IOSMTagConceptParent) keyConcept4);
        
        onto = new OF4OSMOntology();
        onto.addConcept(keyConcept1);
        onto.addConcept(keyConcept2);
        onto.addConcept(keyConcept3);
        onto.addConcept(keyConcept4);
        onto.addConcept(concept1);
        onto.addConcept(concept2);
        onto.addConcept(concept3);
        onto.addConcept(concept4);
	}
	
	public IOF4OSMOntology getOntology(){
		return onto;
	}

	public IOF4OSMFolksonomy getFolksonomy(){
		return folkso;
	}
	
}
