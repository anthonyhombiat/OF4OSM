package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMLocalizedKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 *
 * @author amehiris
 */
public class OSMLocalizedKeyStringValuePropertyTag extends OSMTag implements IOSMLocalizedKeyStringValuePropertyTag {

    private IOSMTagLocalizedKey key;
    private IOSMTagStringValue value;

    public OSMLocalizedKeyStringValuePropertyTag(IOSMTagLocalizedKey key, IOSMTagStringValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagLocalizedKey getKey() {
        return key;
    }

    @Override
    public IOSMTagStringValue getValue() {
        return value;
    }

}
