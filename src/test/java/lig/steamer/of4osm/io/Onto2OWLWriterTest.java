package lig.steamer.of4osm.io;

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
import lig.steamer.of4osm.io.Onto2OWLWriter;
import lig.steamer.of4osm.parse.Folkso2OntoParser;

public class Onto2OWLWriterTest extends TestCase {

	private IOF4OSMOntology of4osm;
	private Onto2OWLWriter writer;
	
	public Onto2OWLWriterTest(String name) {
		
		super(name);
		
		IOSMTagSimpleKey key1 = new OSMTagSimpleKey("historic", "");
		IOSMTagStringValue value1 = new OSMTagStringValue("castle");
		IOSMCategoryTag tag1 = new OSMSimpleCategoryTag(key1, value1);
		IOSMCategoryTagKeyConcept keyConcept1 = Folkso2OntoParser
				.createCategoryTagKeyConcept(tag1);
		IOSMCategoryTagConcept concept1 = Folkso2OntoParser
				.createCategoryTagConcept(tag1, keyConcept1);

		IOSMTagSimpleKey key2 = new OSMTagSimpleKey("amenity", "");
		IOSMTagStringValue value2 = new OSMTagStringValue("restaurant");
		IOSMCategoryTag tag2 = new OSMSimpleCategoryTag(key2, value2);
		IOSMCategoryTagKeyConcept keyConcept2 = Folkso2OntoParser
				.createCategoryTagKeyConcept(tag2);
		IOSMCategoryTagConcept concept2 = Folkso2OntoParser
				.createCategoryTagConcept(tag2, keyConcept2);

		IOSMTagSimpleKey key3 = new OSMTagSimpleKey("tourism", "");
		IOSMTagStringValue value3 = new OSMTagStringValue("hotel");
		IOSMCategoryTag tag3 = new OSMSimpleCategoryTag(key3, value3);
		IOSMCategoryTagKeyConcept keyConcept3 = Folkso2OntoParser
				.createCategoryTagKeyConcept(tag3);
		IOSMCategoryTagConcept concept3 = Folkso2OntoParser
				.createCategoryTagConcept(tag3, keyConcept3);

		of4osm = new OF4OSMOntology();
		of4osm.addConcept(keyConcept1);
		of4osm.addConcept(keyConcept2);
		of4osm.addConcept(keyConcept3);
		of4osm.addConcept(concept1);
		of4osm.addConcept(concept2);
		of4osm.addConcept(concept3);
		
		writer = new Onto2OWLWriter();
	}
	
	public void testWrite() {
		writer.write(of4osm);
	}

}
