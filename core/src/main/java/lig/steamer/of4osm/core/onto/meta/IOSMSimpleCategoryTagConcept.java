package lig.steamer.of4osm.core.onto.meta;

import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMSimpleCategoryTagConcept extends IOSMStatelessTagConcept {

    /**
     * Get the IOSMTag associated with the IConcept
     * @return IOSMTag, the IOSMTag associated with the IConcept
     */
    public IOSMSimpleCategoryTag getTag();

}