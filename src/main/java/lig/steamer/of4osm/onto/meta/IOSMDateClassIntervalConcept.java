package lig.steamer.of4osm.onto.meta;

import java.util.Date;

import lig.steamer.of4osm.folkso.tag.typology.IOSMDatePropertyTag;

/**
 * 
 */
public interface IOSMDateClassIntervalConcept extends IOSMClassIntervalConcept {

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
    public IOSMDatePropertyTag getTag();

}