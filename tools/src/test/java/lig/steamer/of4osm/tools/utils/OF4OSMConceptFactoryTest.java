package lig.steamer.of4osm.tools.utils;

import junit.framework.TestCase;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagSimpleKeyConcept;
import lig.steamer.of4osm.tools.utils.OF4OSMConceptFactory;
import lig.steamer.of4osm.tools.utils.OF4OSMTagIdentifier;
import lig.steamer.of4osm.tools.utils.OF4OSMVocabulary;

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
		
		final IOSMTagSimpleKeyConcept keyConcept = OF4OSMConceptFactory.createOSMTagSimpleKeyConcept((IOSMTagSimpleKey) key);
		
		assertEquals("MockKey", keyConcept.getIRI().getRemainder().get());
		assertEquals("MockKey", keyConcept.getDefaultLabel());
		assertEquals(OF4OSMVocabulary.OSMTAGSIMPLEKEYCONCEPT_IRI 
				+ OF4OSMVocabulary.IRI_SEPARATOR + "MockKey", keyConcept.getIRI().toString());
	}
	
	public void testCreateOSMCategoryTagConcept(){
		
		final String keyLabel = "  mock key_  ";
		final IOSMTagKey key = OF4OSMTagIdentifier.identifyKey(keyLabel, "");
		
		final String valueLabel = "  mock value_  ";
		final IOSMTagStringValue value = (IOSMTagStringValue) OF4OSMTagIdentifier.identifyValue(valueLabel);
		
		final IOSMSimpleCategoryTag tag = (IOSMSimpleCategoryTag) OF4OSMTagIdentifier.identifyTag(key, value);
		
		final IOSMTagSimpleKeyConcept keyConcept = OF4OSMConceptFactory.createOSMTagSimpleKeyConcept((IOSMTagSimpleKey) tag.getKey());
		final IOSMSimpleCategoryTagConcept tagConcept = OF4OSMConceptFactory.createOSMSimpleCategoryTagConcept((IOSMSimpleCategoryTag) tag, (IOSMStatelessTagConceptParent) keyConcept);
		
		assertEquals("MockValueMockKey", tagConcept.getIRI().getRemainder().get());
		assertEquals("MockValueMockKey", tagConcept.getDefaultLabel());
		assertEquals(OF4OSMVocabulary.OSMSTATELESSTAGCONCEPT_IRI 
				+ OF4OSMVocabulary.IRI_SEPARATOR + "MockValueMockKey", tagConcept.getIRI().toString());
	}
	
}
