package lig.steamer.of4osm.core.onto.meta;

import java.util.Date;

import lig.steamer.of4osm.core.folkso.tag.IOSMDateValuePropertyTag;

/**
 * 
 */
public interface IOSMDiscretizedOSMDatePropertyTagConcept extends IOSMDiscretizedOSMPropertyTagConcept {

    /**
     * @return
     */
    public Date getBinf();

    /**
     * @return
     */
    public Date getBsup();

    /**
     * @return
     */
    public IOSMDateValuePropertyTag getTag();

}