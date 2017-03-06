package lig.steamer.of4osm.core.onto.meta;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMTagKeyConcept extends IConcept {

	/**
	 * Get the IOSMTagKey related to the IConcept
	 * @return IOSMTagKey, the IOSMTagKey
	 */
	public IOSMTagKey getKey();
	
}
