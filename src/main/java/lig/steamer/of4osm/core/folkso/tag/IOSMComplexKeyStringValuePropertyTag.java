package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMComplexKeyStringValuePropertyTag extends IOSMStringValuePropertyTag {

    @Override
    public IOSMTagComplexKey getKey();

}