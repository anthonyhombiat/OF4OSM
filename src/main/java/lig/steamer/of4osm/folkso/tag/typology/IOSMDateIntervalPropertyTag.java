package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagDateIntervalValue;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;

/**
 * 
 */
public interface IOSMDateIntervalPropertyTag extends IOSMDatePropertyTag {

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public IOSMTagDateIntervalValue getValue();

}