package lig.steamer.of4osm.core.folkso.tag.typology;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagNumericValue;

/**
 * 
 */
public interface IOSMSimpleNumericPropertyTag extends IOSMNumericPropertyTag {

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public IOSMTagNumericValue getValue();

}