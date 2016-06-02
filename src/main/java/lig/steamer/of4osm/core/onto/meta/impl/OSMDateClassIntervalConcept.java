package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Date;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.typology.IOSMDatePropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMDateClassIntervalConcept;

/**
 * 
 */
public class OSMDateClassIntervalConcept extends OSMClassIntervalConcept implements IOSMDateClassIntervalConcept {

    /**
     * Default constructor
     */
    public OSMDateClassIntervalConcept() {
    }

    /**
     * 
     */
    public IOSMDatePropertyTag tag;

    /**
     * 
     */
    public Date binf;

    /**
     * 
     */
    public Date bsup;

    /**
     * @return
     */
    public Date getBinf() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Date getBsup() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public IOSMDatePropertyTag getTag() {
        // TODO implement here
        return null;
    }

	@Override
	public IOSMTagKey getKey() {
		// TODO Auto-generated method stub
		return null;
	}

}