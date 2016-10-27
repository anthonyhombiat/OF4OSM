package lig.steamer.of4osm.util;

import junit.framework.TestCase;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

public class OF4OSMConceptFactoryTest extends TestCase {
	
	public OF4OSMConceptFactoryTest(String name) {
		super(name);
	}

	public void testCreateHighLevelConcept(){
		final IHighLevelConcept concept = OF4OSMConceptFactory.createHighLevelConcept("  mock  label_  ");
		assertEquals("MockLabel", concept.getIRI().getRemainder().get());
		assertEquals("MockLabel", concept.getDefaultLabel());
		assertEquals(OF4OSMVocabulary.HIGHLEVELCONCEPT_IRI 
				+ OF4OSMVocabulary.IRI_SEPARATOR + "MockLabel", concept.getIRI().toString());
	}
	
	public void testCreateOSMCategoryTagKeyConcept(){
		
		final String keyLabel = "  mock key_  ";
		final IOSMTagKey key = OF4OSMTagIdentifier.identifyKey(keyLabel, "");
		
		final IOSMCategoryTagKeyConcept keyConcept = OF4OSMConceptFactory.createOSMCategoryTagKeyConcept(key);
		
		assertEquals("MockKey", keyConcept.getIRI().getRemainder().get());
		assertEquals("MockKey", keyConcept.getDefaultLabel());
		assertEquals(OF4OSMVocabulary.OSMTAGKEYCONCEPT_IRI 
				+ OF4OSMVocabulary.IRI_SEPARATOR + "MockKey", keyConcept.getIRI().toString());
	}
	
	public void testCreateOSMCategoryTagConcept(){
		
		final String keyLabel = "  mock key_  ";
		final IOSMTagKey key = OF4OSMTagIdentifier.identifyKey(keyLabel, "");
		
		final String valueLabel = "  mock value_  ";
		final IOSMTagStringValue value = (IOSMTagStringValue) OF4OSMTagIdentifier.identifyValue(valueLabel);
		
		final IOSMCategoryTag tag = (IOSMCategoryTag) OF4OSMTagIdentifier.identifyTag(key, value);
		
		final IOSMCategoryTagKeyConcept keyConcept = OF4OSMConceptFactory.createOSMCategoryTagKeyConcept(tag.getKey());
		final IOSMCategoryTagConcept tagConcept = OF4OSMConceptFactory.createOSMCategoryTagConcept(tag, (IOSMTagConceptParent) keyConcept);
		
		assertEquals("MockValueMockKey", tagConcept.getIRI().getRemainder().get());
		assertEquals("MockValueMockKey", tagConcept.getDefaultLabel());
		assertEquals(OF4OSMVocabulary.OSMTAGCONCEPT_IRI 
				+ OF4OSMVocabulary.IRI_SEPARATOR + "MockValueMockKey", tagConcept.getIRI().toString());
	}
	
}
