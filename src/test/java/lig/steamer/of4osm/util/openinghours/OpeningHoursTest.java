package lig.steamer.of4osm.util.openinghours;

import junit.framework.TestCase;

public class OpeningHoursTest extends TestCase {

	public OpeningHoursTest(String name) {
		super(name);
	}

	public void testIsOpeningHours() {
		assertTrue(OpeningHours.isOpeningHours("Mo 9:00-20:00; Fr 11:00-22:00; Sa-Su 11:00-20:00"));
		assertFalse(OpeningHours.isOpeningHours("NotAnOpeningHours"));
	}

}
