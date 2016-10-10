package lig.steamer.of4osm.core.onto.meta;

import lig.steamer.of4osm.core.folkso.tag.IOSMNumericValuePropertyTag;

/**
 * 
 */
public interface IOSMDiscretizedOSMNumericPropertyTagConcept extends IOSMDiscretizedOSMPropertyTagConcept {

    /**
     * @return
     */
    public Double getBinf();

    /**
     * @return
     */
    public Double getBsup();

    /**
     * @return
     */
    public IOSMNumericValuePropertyTag getTag();

}