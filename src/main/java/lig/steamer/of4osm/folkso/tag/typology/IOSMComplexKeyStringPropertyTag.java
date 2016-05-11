package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagStringSimpleValue;

/**
 * 
 */
public interface IOSMComplexKeyStringPropertyTag extends IOSMStringValuePropertyTag {

    /**
     * @return
     */
    public IOSMTagComplexKey getKey();

    /**
     * @return
     */
    public IOSMTagStringSimpleValue getValue();

}