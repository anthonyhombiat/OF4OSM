package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagStringSimpleValue;

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
    public IOSMTagStringSimpleValue getValue();

}