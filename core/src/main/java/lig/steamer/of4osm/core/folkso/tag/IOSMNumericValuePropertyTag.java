package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMNumericValuePropertyTag extends IOSMPropertyTag {

	 @Override
	 public IOSMTagNumericValue getValue();
	
}