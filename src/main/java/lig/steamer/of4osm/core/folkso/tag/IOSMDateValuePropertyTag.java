package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagDateValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMDateValuePropertyTag extends IOSMPropertyTag {

	@Override
    public IOSMTagDateValue getValue();
	
}