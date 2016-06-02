package lig.steamer.of4osm.core.folkso.tag.typology;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagBooleanValue;

/**
 * 
 */
public interface IOSMSimpleBooleanPropertyTag extends IOSMBooleanSimpleValuePropertyTag {

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public IOSMTagBooleanValue getValue();

}