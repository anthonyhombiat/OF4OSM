package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagMultipleValue;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;

/**
 *
 */
public interface IOSMMultipleCategoryTag extends IOSMCategoryTag {

    @Override
    public IOSMTagSimpleKey getKey();

    @Override
    public IOSMTagMultipleValue getValue();

}
