package lig.steamer.of4osm.core.folkso.tag.typology;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagDateValue;

/**
 * 
 */
public interface IOSMComplexKeyDatePropertyTag extends IOSMDatePropertyTag {

    /**
     * @return
     */
    public IOSMTagComplexKey getKey();

    /**
     * @return
     */
    public IOSMTagDateValue getValue();

}