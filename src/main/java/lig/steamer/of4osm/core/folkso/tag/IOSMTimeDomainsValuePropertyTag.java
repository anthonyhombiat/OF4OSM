package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagTimeDomainsValue;

/**
 *
 * @author amehiris
 */
public interface IOSMTimeDomainsValuePropertyTag extends IOSMPropertyTag {

    @Override
    public IOSMTagSimpleKey getKey();

    @Override
    public IOSMTagTimeDomainsValue getValue();
}
