package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 *
 */
public interface IOSMSimpleCategoryTag extends IOSMCategoryTag {

    @Override
    public IOSMTagSimpleKey getKey();

    @Override
    public IOSMTagStringValue getValue();

}
