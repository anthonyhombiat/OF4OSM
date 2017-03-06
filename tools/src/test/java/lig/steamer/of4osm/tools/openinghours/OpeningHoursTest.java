package lig.steamer.of4osm.tools.openinghours;

import junit.framework.TestCase;
import lig.steamer.of4osm.tools.openinghours.OpeningHours;

public class OpeningHoursTest extends TestCase {

	public OpeningHoursTest(String name) {
		super(name);
	}

	public void testIsOpeningHours() {
		assertTrue(OpeningHours.isOpeningHours("Mo 9:00-20:00; Fr 11:00-22:00; Sa-Su 11:00-20:00"));
		assertFalse(OpeningHours.isOpeningHours("NotAnOpeningHours"));
	}

}
