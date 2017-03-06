package lig.steamer.of4osm.core.folkso.tag.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMTimeDomainsValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagTimeDomainsValue;

/**
 *
 * @author amehiris
 */
public class OSMTimeDomainsValuePropertyTag extends OSMTag implements IOSMTimeDomainsValuePropertyTag {

    private IOSMTagSimpleKey key;
    private IOSMTagTimeDomainsValue value;

    public OSMTimeDomainsValuePropertyTag(IOSMTagSimpleKey key, IOSMTagTimeDomainsValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public IOSMTagSimpleKey getKey() {
        return key;
    }

    @Override
    public IOSMTagTimeDomainsValue getValue() {
        return value;
    }

}
