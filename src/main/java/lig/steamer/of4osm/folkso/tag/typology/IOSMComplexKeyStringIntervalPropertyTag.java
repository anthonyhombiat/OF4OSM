package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagStringIntervalValue;

/**
 * 
 */
public interface IOSMComplexKeyStringIntervalPropertyTag extends IOSMStringValuePropertyTag {

    /**
     * @return
     */
    public IOSMTagComplexKey getKey();

    /**
     * @return
     */
    public IOSMTagStringIntervalValue getValue();

}