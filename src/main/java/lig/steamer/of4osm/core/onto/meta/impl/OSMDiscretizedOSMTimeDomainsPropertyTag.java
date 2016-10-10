/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
