package lig.steamer.of4osm.core.onto.meta;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMTagConcept extends IConcept {

    /**
     * Get the IOSMTag associated with the IOSMTagConcept
     * @return IOSMTag, the IOSMTag associated with the IOSMTagConcept
     */
    public IOSMTag getTag();

}