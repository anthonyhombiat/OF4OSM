package lig.steamer.of4osm.parse;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;
import lig.steamer.of4osm.core.onto.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.data.MockData;
import lig.steamer.of4osm.io.OF4OSMOntoWriterOWL;

/**
 *
 * @author amehiris
 */
public class OF4OSMFolkso2OntoParserTest extends TestCase {

	public OF4OSMFolkso2OntoParserTest(String name) {
		super(name);
	}

	/**
	 * Test of addConceptsFromFolkso method, of class Folkso2OntoParser.
	 */
	public void testAddConceptsFromFolkso() {

		MockData mockData = new MockData();

		IOF4OSMOntology of4osm = new OF4OSMOntology();
		OF4OSMFolkso2OntoParser.addConceptsFromFolkso(of4osm,
				mockData.getFolksonomy());

		OF4OSMOntoWriterOWL writer = new OF4OSMOntoWriterOWL();
		writer.write(of4osm, OF4OSMFolkso2OntoParserTest.class.getName()
				+ new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
	}

}
