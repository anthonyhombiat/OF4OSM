package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMSimpleKeyNumericValuePropertyTag extends IOSMNumericValuePropertyTag {

    @Override
    public IOSMTagSimpleKey getKey();

}