package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagStringIntervalValue;

/**
 * 
 */
public interface IOSMStringIntervalPropertyTag extends IOSMStringValuePropertyTag {

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public IOSMTagStringIntervalValue getValue();

}