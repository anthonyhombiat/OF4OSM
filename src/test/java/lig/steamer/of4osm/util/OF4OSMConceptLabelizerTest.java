package lig.steamer.of4osm.util;

import junit.framework.TestCase;

public class OF4OSMConceptLabelizerTest extends TestCase {

	public OF4OSMConceptLabelizerTest(String name) {
		super(name);
	}

	public void testNormalize(){
		
		String label = "mock label_that needs_to_be Normalized";
		String expectedLabel = "MockLabelThatNeedsToBeNormalized";
		
		assertEquals(expectedLabel, OF4OSMConceptLabelizer.normalize(label));
		
	}
	
}
