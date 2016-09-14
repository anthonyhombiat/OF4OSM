package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;

/**
 * 
 */
public interface IOSMNumericPropertyTag extends IOSMPropertyTag {

    /**
     * @return
     */
    public IOSMTagNumericValue getValue();

}