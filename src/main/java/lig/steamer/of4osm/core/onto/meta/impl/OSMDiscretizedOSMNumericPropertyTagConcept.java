package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.IOSMNumericValuePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMNumericPropertyTagConcept;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMDiscretizedOSMNumericPropertyTagConcept extends OSMDiscretizedOSMPropertyTagConcept implements IOSMDiscretizedOSMNumericPropertyTagConcept {

	public IOSMNumericValuePropertyTag tag;
	public Double binf;
	public Double bsup;

	public OSMDiscretizedOSMNumericPropertyTagConcept(String label) {
		super(label);
	}
	
    @Override
    public Double getBinf() {
        return binf;
    }

    @Override
    public Double getBsup() {
       return bsup;
    }

    @Override
    public IOSMNumericValuePropertyTag getTag() {
        return tag;
    }

}