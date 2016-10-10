package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 *
 */
public interface IOSMComplexKeyNumericValuePropertyTag extends IOSMNumericValuePropertyTag {

    @Override
    public IOSMTagComplexKey getKey();

    @Override
    public IOSMTagNumericValue getValue();

}
