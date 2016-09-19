package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 *
 */
public interface IOSMSimpleNumericPropertyTag extends IOSMNumericPropertyTag {

    @Override
    public IOSMTagSimpleKey getKey();

    @Override
    public IOSMTagNumericValue getValue();

}
