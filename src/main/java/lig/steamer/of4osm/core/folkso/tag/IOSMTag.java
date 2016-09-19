package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;

/**
 *
 */
public interface IOSMTag {

    public IOSMTagKey getKey();

    public IOSMTagValue getValue();

    public String getWikiURL();

}
