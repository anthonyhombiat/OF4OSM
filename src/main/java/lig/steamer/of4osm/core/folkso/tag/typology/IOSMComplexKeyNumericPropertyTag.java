package lig.steamer.of4osm.core.folkso.tag.typology;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagNumericValue;

/**
 * 
 */
public interface IOSMComplexKeyNumericPropertyTag extends IOSMNumericPropertyTag {

    /**
     * @return
     */
    public IOSMTagComplexKey getKey();

    /**
     * @return
     */
    public IOSMTagNumericValue getValue();

}