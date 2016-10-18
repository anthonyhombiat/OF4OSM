package lig.steamer.of4osm.io;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;
import lig.steamer.of4osm.io.OF4OSMOntoWriterOWL;
import lig.steamer.of4osm.parse.OF4OSMFolkso2OntoParser;

public class OF4OSMOntoWriterOWLTest extends TestCase {

	private IOF4OSMOntology of4osm;
	private OF4OSMOntoWriterOWL writer;
	
	public OF4OSMOntoWriterOWLTest(String name) {
		
		super(name);
		
		IOSMTagSimpleKey key1 = new OSMTagSimpleKey("historic", "");
		IOSMTagStringValue value1 = new OSMTagStringValue("castle");
		IOSMCategoryTag tag1 = new OSMSimpleCategoryTag(key1, value1);
		IOSMCategoryTagKeyConcept keyConcept1 = OF4OSMFolkso2OntoParser
				.createCategoryTagKeyConcept(tag1);
		IOSMCategoryTagConcept concept1 = OF4OSMFolkso2OntoParser
				.createCategoryTagConcept(tag1, (IOSMTagConceptParent) keyConcept1);

		IOSMTagSimpleKey key2 = new OSMTagSimpleKey("amenity", "");
		IOSMTagStringValue value2 = new OSMTagStringValue("restaurant");
		IOSMCategoryTag tag2 = new OSMSimpleCategoryTag(key2, value2);
		IOSMCategoryTagKeyConcept keyConcept2 = OF4OSMFolkso2OntoParser
				.createCategoryTagKeyConcept(tag2);
		IOSMCategoryTagConcept concept2 = OF4OSMFolkso2OntoParser
				.createCategoryTagConcept(tag2, (IOSMTagConceptParent) keyConcept2);

		IOSMTagSimpleKey key3 = new OSMTagSimpleKey("tourism", "");
		IOSMTagStringValue value3 = new OSMTagStringValue("hotel");
		IOSMCategoryTag tag3 = new OSMSimpleCategoryTag(key3, value3);
		IOSMCategoryTagKeyConcept keyConcept3 = OF4OSMFolkso2OntoParser
				.createCategoryTagKeyConcept(tag3);
		IOSMCategoryTagConcept concept3 = OF4OSMFolkso2OntoParser
				.createCategoryTagConcept(tag3, (IOSMTagConceptParent) keyConcept3);

		of4osm = new OF4OSMOntology();
		of4osm.addConcept(keyConcept1);
		of4osm.addConcept(keyConcept2);
		of4osm.addConcept(keyConcept3);
		of4osm.addConcept(concept1);
		of4osm.addConcept(concept2);
		of4osm.addConcept(concept3);
		
		writer = new OF4OSMOntoWriterOWL();
	}
	
	public void testWrite() {
		String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		writer.write(of4osm, "of4osm-test" + now);
	}

}
