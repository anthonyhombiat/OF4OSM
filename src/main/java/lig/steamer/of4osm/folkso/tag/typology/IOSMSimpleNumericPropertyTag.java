package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagNumericSimpleValue;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;

/**
 * 
 */
public interface IOSMSimpleNumericPropertyTag extends IOSMNumericPropertyTag {

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public IOSMTagNumericSimpleValue getValue();

}