package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Date;

import lig.steamer.of4osm.core.folkso.tag.IOSMDateValuePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMDatePropertyTagConcept;

/**
 * 
 */
public class OSMDiscretizedOSMDatePropertyTagConcept extends OSMDiscretizedOSMPropertyTagConcept implements IOSMDiscretizedOSMDatePropertyTagConcept {

    public IOSMDateValuePropertyTag tag;
    public Date binf;
    public Date bsup;

    public OSMDiscretizedOSMDatePropertyTagConcept() {
    }
    
    /**
     * @return
     */
    public Date getBinf() {
        return binf;
    }

    /**
     * @return
     */
    public Date getBsup() {
        return bsup;
    }

    /**
     * @return
     */
    public IOSMDateValuePropertyTag getTag() {
       return tag;
    }

}