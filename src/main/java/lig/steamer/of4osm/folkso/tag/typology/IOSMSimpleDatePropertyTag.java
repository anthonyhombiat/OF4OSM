package lig.steamer.of4osm.folkso.tag.typology;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagDateSimpleValue;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;

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
    public IOSMTagDateSimpleValue getValue();

}