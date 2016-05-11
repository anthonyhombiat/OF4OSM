package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagDateIntervalValue;

/**
 * 
 */
public interface IOSMComplexKeyDateIntervalPropertyTag extends IOSMDatePropertyTag {

    /**
     * @return
     */
    public IOSMTagComplexKey getKey();

    /**
     * @return
     */
    public IOSMTagDateIntervalValue getValue();

}