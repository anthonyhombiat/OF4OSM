package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMBooleanValuePropertyTag extends IOSMPropertyTag {

	@Override
	public IOSMTagBooleanValue getValue();

}