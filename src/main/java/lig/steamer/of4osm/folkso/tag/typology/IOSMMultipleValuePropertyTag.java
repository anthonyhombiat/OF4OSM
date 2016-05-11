package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagMultipleValue;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;

/**
 * 
 */
public interface IOSMMultipleValuePropertyTag extends IOSMPropertyTag {

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public IOSMTagMultipleValue getValue();

}