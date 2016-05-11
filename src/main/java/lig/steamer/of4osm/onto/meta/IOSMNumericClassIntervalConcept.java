package lig.steamer.of4osm.onto.meta;

import lig.steamer.of4osm.folkso.tag.typology.IOSMNumericPropertyTag;

/**
 * 
 */
public interface IOSMNumericClassIntervalConcept extends IOSMClassIntervalConcept {

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
    public IOSMNumericPropertyTag getTag();

}