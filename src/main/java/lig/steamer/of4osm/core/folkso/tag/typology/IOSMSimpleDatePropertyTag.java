package lig.steamer.of4osm.core.folkso.tag.typology;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagDateValue;

/**
 * 
 */
public interface IOSMSimpleDatePropertyTag extends IOSMDatePropertyTag {

    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public IOSMTagDateValue getValue();

}