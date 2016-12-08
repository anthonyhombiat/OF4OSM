package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMSimpleKeyBooleanValuePropertyTag extends IOSMBooleanValuePropertyTag {

    @Override
    public IOSMTagSimpleKey getKey();

    @Override
    public IOSMTagBooleanValue getValue();

}