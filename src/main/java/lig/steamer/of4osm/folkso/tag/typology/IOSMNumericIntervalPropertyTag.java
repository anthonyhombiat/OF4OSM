package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagNumericIntervalValue;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;

/**
 * 
 */
public interface IOSMNumericIntervalPropertyTag extends IOSMNumericPropertyTag {

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public IOSMTagNumericIntervalValue getValue();

}