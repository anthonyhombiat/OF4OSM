package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 *
 * @author amehiris
 */
public interface IOSMStatefulCategoryTag extends IOSMCategoryTag {

    @Override
    public IOSMTagStatefulKey getKey();

    @Override
    public IOSMTagStringValue getValue();
}