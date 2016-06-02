package lig.steamer.of4osm.core.folkso.tag.typology;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagBooleanValue;

/**
 * 
 */
public interface IOSMComplexKeyBooleanPropertyTag extends IOSMBooleanSimpleValuePropertyTag {

    /**
     * @return
     */
    public IOSMTagComplexKey getKey();

    /**
     * @return
     */
    public IOSMTagBooleanValue getValue();

}