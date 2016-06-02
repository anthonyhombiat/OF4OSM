package lig.steamer.of4osm.core.onto.meta.impl;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.typology.IOSMNumericPropertyTag;
import lig.steamer.of4osm.core.onto.meta.IOSMNumericClassIntervalConcept;

/**
 * 
 */
public class OSMNumericClassIntervalConcept extends OSMClassIntervalConcept implements IOSMNumericClassIntervalConcept {

    /**
     * Default constructor
     */
    public OSMNumericClassIntervalConcept() {
    }

    /**
     * 
     */
    public IOSMNumericPropertyTag tag;

    /**
     * 
     */
    public Double binf;

    /**
     * 
     */
    public Double bsup;

    /**
     * @return
     */
    public Double getBinf() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Double getBsup() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public IOSMNumericPropertyTag getTag() {
        // TODO implement here
        return null;
    }

	@Override
	public IOSMTagKey getKey() {
		// TODO Auto-generated method stub
		return null;
	}

}