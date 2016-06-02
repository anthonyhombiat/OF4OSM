package lig.steamer.of4osm.core.folkso.tag.typology;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagMultipleValue;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagSimpleKey;

/**
 * 
 */
public interface IOSMMultipleValueCategoryTag extends IOSMCategoryTag {

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public IOSMTagMultipleValue getValue();

}