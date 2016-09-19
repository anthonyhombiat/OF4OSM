/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;

/**
 *
 * @author amehiris
 */
public interface IOSMLocalizedKeyStringValueTag extends IOSMStringValuePropertyTag {

    @Override
    public IOSMTagLocalizedKey getKey();

    @Override
    public IOSMTagStringValue getValue();
}
