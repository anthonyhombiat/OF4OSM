package lig.steamer.of4osm.tools.data;


import java.util.HashSet;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.IOF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagBooleanValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.onto.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IOSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConcept;
import lig.steamer.of4osm.tools.utils.OF4OSMConceptFactory;

public class MockData {
	
	public IOF4OSMFolksonomy folkso;
	public IOF4OSMOntology onto;
	
	public MockData(){
				
		final IOSMTagStatefulKey key1 = new OSMTagStatefulKey("disused:historic", "");
    	final IOSMTagStringValue value1 = new OSMTagStringValue("castle");
    	final IOSMStatefulCategoryTag tag1 = new OSMStatefulCategoryTag(key1, value1);
    	
    	final IOSMTagSimpleKey key2 = new OSMTagSimpleKey("amenity", "");
    	final IOSMTagStringValue value2 = new OSMTagStringValue("restaurant");
    	final IOSMSimpleCategoryTag tag2 = new OSMSimpleCategoryTag(key2, value2);
    	
    	final IOSMTagSimpleKey key3 = new OSMTagSimpleKey("tourism", "");
        final IOSMTagStringValue value3 = new OSMTagStringValue("hotel");
        final IOSMSimpleCategoryTag tag3 = new OSMSimpleCategoryTag(key3, value3);
        
        final IOSMTagSimpleKey key4 = new OSMTagSimpleKey("amenity", "");
        final IOSMTagStringValue value4 = new OSMTagStringValue("bar");
        final IOSMSimpleCategoryTag tag4 = new OSMSimpleCategoryTag(key4, value4);
        
        final IOSMTagSimpleKey key5 = new OSMTagSimpleKey("building", "");
        final IOSMTagBooleanValue value5 = new OSMTagBooleanValue(true);
        final IOSMSimpleKeyBooleanValuePropertyTag tag5 = new OSMSimpleKeyBooleanValuePropertyTag(key5, value5);
        
        Set<IOSMTag> tags = new HashSet<>();
        tags.add(tag1);
        tags.add(tag2);
        tags.add(tag3);
        tags.add(tag4);
        tags.add(tag5);
        
        folkso = new OF4OSMFolksonomy();
        folkso.addTagsByElement("test", tags);
    	
    	final IOSMTagStatefulKeyConcept keyConcept1 = OF4OSMConceptFactory.createOSMTagStatefulKeyConcept((IOSMTagStatefulKey) tag1.getKey());
    	final IOSMStatefulCategoryTagConcept concept1 = OF4OSMConceptFactory.createOSMStatefulCategoryTagConcept(tag1, (IOSMStatefulTagConceptParent) keyConcept1);

    	final IOSMTagSimpleKeyConcept keyConcept2 = OF4OSMConceptFactory.createOSMTagSimpleKeyConcept((IOSMTagSimpleKey) tag2.getKey());
    	final IOSMSimpleCategoryTagConcept concept2 = OF4OSMConceptFactory.createOSMSimpleCategoryTagConcept(tag2, (IOSMStatelessTagConceptParent) keyConcept2);

        final IOSMTagSimpleKeyConcept keyConcept3 = OF4OSMConceptFactory.createOSMTagSimpleKeyConcept((IOSMTagSimpleKey) tag3.getKey());
        final IOSMSimpleCategoryTagConcept concept3 = OF4OSMConceptFactory.createOSMSimpleCategoryTagConcept(tag3, (IOSMStatelessTagConceptParent) keyConcept3);

        final IOSMTagSimpleKeyConcept keyConcept4 = OF4OSMConceptFactory.createOSMTagSimpleKeyConcept((IOSMTagSimpleKey) tag4.getKey());
        final IOSMSimpleCategoryTagConcept concept4 = OF4OSMConceptFactory.createOSMSimpleCategoryTagConcept(tag4, (IOSMStatelessTagConceptParent) keyConcept4);
        
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
