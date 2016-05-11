package lig.steamer.of4osm.onto.meta.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagKey;
import lig.steamer.of4osm.folkso.tag.typology.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.onto.meta.IOSMSimpleTagKeyConcept;

/**
 * 
 */
public class OSMSimpleTagKeyConcept extends OSMTagKeyConcept implements IOSMSimpleTagKeyConcept {

    /**
     * Default constructor
     */
    public OSMSimpleTagKeyConcept() {
    }

    /**
     * 
     */
    public IOSMSimpleCategoryTag tag;

    /**
     * @return
     */
    public IOSMTagKey getKey(){
     return null;	
    }

    /**
     * @return
     */
    public IOSMSimpleCategoryTag getTag() {
        // TODO implement here
        return null;
    }

}