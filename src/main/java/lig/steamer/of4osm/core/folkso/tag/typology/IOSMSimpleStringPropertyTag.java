package lig.steamer.of4osm.core.folkso.tag.typology;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagStringValue;

/**
 * 
 */
public interface IOSMSimpleStringPropertyTag extends IOSMStringValuePropertyTag {

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public IOSMTagStringValue getValue();

}