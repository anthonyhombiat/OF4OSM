package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;

/**
 *
 */
public interface IOSMSimpleBooleanPropertyTag extends IOSMBooleanSimpleValuePropertyTag {

    @Override
    public IOSMTagSimpleKey getKey();

    @Override
    public IOSMTagBooleanValue getValue();

}
