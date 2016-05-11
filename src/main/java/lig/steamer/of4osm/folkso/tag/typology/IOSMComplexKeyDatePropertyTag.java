package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagDateSimpleValue;

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
    public IOSMTagDateSimpleValue getValue();

}