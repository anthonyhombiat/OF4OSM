package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMStringValuePropertyTag extends IOSMPropertyTag {

	@Override
    public IOSMTagStringValue getValue();
	
}