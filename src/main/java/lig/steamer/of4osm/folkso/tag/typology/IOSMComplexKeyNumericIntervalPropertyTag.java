package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagNumericIntervalValue;

/**
 * 
 */
public interface IOSMComplexKeyNumericIntervalPropertyTag extends IOSMNumericPropertyTag {

    /**
     * @return
     */
    public IOSMTagComplexKey getKey();

    /**
     * @return
     */
    public IOSMTagNumericIntervalValue getValue();

}