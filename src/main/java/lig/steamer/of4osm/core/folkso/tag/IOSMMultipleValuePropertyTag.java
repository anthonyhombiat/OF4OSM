package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagMultipleValue;

/**
 *
 */
public interface IOSMMultipleValuePropertyTag extends IOSMPropertyTag {

    @Override
    public IOSMTagSimpleKey getKey();

    @Override
    public IOSMTagMultipleValue getValue();

}
