package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;


/**
 * 
 */
public interface IOSMTag {



    /**
     * @return
     */
    public IOSMTagKey getKey();

    /**
     * @return
     */
    public IOSMTagValue getValue();

    /**
     * @return
     */
    public String getWikiURL();

}