package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagNumericSimpleValue;

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
    public IOSMTagNumericSimpleValue getValue();

}