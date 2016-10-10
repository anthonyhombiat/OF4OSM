package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;

/**
 *
 */
public interface IOSMComplexKeyBooleanValuePropertyTag extends IOSMBooleanValuePropertyTag {

    @Override
    public IOSMTagComplexKey getKey();

    @Override
    public IOSMTagBooleanValue getValue();

}
