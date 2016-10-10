package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagDateValue;

/**
 *
 */
public interface IOSMComplexKeyDateValuePropertyTag extends IOSMDateValuePropertyTag {

    @Override
    public IOSMTagComplexKey getKey();

    @Override
    public IOSMTagDateValue getValue();

}
