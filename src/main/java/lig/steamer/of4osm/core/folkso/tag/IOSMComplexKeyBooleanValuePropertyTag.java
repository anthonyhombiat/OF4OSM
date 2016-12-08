package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMComplexKeyBooleanValuePropertyTag extends IOSMBooleanValuePropertyTag {

    @Override
    public IOSMTagComplexKey getKey();

    @Override
    public IOSMTagBooleanValue getValue();

}