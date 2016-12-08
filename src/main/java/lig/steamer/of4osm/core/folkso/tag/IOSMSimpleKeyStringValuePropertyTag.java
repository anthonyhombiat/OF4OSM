package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMSimpleKeyStringValuePropertyTag extends IOSMStringValuePropertyTag {

    @Override
    public IOSMTagSimpleKey getKey();

    @Override
    public IOSMTagStringValue getValue();

}