package lig.steamer.of4osm.core.folkso.tag.typology;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagStringValue;

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
    public IOSMTagStringValue getValue();

}