package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;

/**
 *
 */
public interface IOSMComplexKeyBooleanPropertyTag extends IOSMBooleanSimpleValuePropertyTag {

    @Override
    public IOSMTagComplexKey getKey();

    @Override
    public IOSMTagBooleanValue getValue();

}
