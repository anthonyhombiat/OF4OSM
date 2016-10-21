package lig.steamer.of4osm.io;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;
import lig.steamer.of4osm.data.MockData;

public class OF4OSMOntoWriterOWLTest extends TestCase {
	
	public OF4OSMOntoWriterOWLTest(String name) {
		super(name);
	}
	
	public void testWrite() {
		MockData mockData = new MockData();
		OF4OSMOntoWriterOWL writer = new OF4OSMOntoWriterOWL();
		writer.write(
				mockData.getOntology(), 
				OF4OSMOntoWriterOWLTest.class.getName() + 
				new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
	}

}
