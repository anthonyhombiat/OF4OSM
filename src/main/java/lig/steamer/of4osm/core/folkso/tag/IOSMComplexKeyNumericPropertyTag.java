package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 *
 */
public interface IOSMComplexKeyNumericPropertyTag extends IOSMNumericPropertyTag {

    @Override
    public IOSMTagComplexKey getKey();

    @Override
    public IOSMTagNumericValue getValue();

}
