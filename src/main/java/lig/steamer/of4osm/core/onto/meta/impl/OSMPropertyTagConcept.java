package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMPropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMPropertyTagConcept;

/**
 *
 * @author amehiris
 */
public abstract class OSMPropertyTagConcept extends OSMTagConcept implements IOSMPropertyTagConcept {
	
	@Override
    public abstract IOSMPropertyTag getTag();
	
}
