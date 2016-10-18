package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Date;

import lig.steamer.of4osm.core.folkso.tag.IOSMDateValuePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMDatePropertyTagConcept;

/**
 *
 * @author amehiris
 */
public class OSMDiscretizedOSMTimeDomainsPropertyTag  extends OSMDiscretizedOSMPropertyTagConcept implements IOSMDiscretizedOSMDatePropertyTagConcept {

	public IOSMDateValuePropertyTag tag;
	
	public OSMDiscretizedOSMTimeDomainsPropertyTag(String label) {
		super(label);
	}
	
	@Override
	public Date getBinf() {
		return null;
	}

	@Override
	public Date getBsup() {
		return null;
	}

	@Override
	public IOSMDateValuePropertyTag getTag() {
		return tag;
	}
    
}
