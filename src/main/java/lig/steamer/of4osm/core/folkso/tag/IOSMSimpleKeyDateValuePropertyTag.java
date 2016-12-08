package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagDateValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMSimpleKeyDateValuePropertyTag extends IOSMDateValuePropertyTag {

    @Override
    public IOSMTagSimpleKey getKey();

    @Override
    public IOSMTagDateValue getValue();

}