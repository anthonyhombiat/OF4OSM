package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMComplexKeyStringValuePropertyTag extends IOSMStringValuePropertyTag {

    @Override
    public IOSMTagComplexKey getKey();

    @Override
    public IOSMTagStringValue getValue();

}