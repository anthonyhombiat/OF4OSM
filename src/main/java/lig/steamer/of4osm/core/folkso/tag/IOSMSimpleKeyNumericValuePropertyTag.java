package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 *
 */
public interface IOSMSimpleKeyNumericValuePropertyTag extends IOSMNumericValuePropertyTag {

    @Override
    public IOSMTagSimpleKey getKey();

    @Override
    public IOSMTagNumericValue getValue();

}
