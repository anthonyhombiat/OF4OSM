package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 *
 * @author amehiris
 */
public interface IOSMLocalizedKeyStringValuePropertyTag extends IOSMStringValuePropertyTag {

    @Override
    public IOSMTagLocalizedKey getKey();

    @Override
    public IOSMTagStringValue getValue();
}