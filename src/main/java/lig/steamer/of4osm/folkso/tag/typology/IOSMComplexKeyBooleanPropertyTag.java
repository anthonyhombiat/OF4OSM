package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagBooleanSimpleValue;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;

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
    public IOSMTagBooleanSimpleValue getValue();

}