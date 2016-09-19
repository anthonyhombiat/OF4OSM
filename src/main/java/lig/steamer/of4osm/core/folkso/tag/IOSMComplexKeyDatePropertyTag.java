package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagDateValue;

/**
 *
 */
public interface IOSMComplexKeyDatePropertyTag extends IOSMDatePropertyTag {

    @Override
    public IOSMTagComplexKey getKey();

    @Override
    public IOSMTagDateValue getValue();

}
