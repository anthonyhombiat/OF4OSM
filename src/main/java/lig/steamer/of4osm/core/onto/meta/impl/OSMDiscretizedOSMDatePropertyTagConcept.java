package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMDatePropertyTagConcept;

/**
 * 
 */
public class OSMDiscretizedOSMDatePropertyTagConcept extends OSMDiscretizedOSMPropertyTagConcept implements IOSMDiscretizedOSMDatePropertyTagConcept {

    /**
     * Default constructor
     */
    public OSMDiscretizedOSMDatePropertyTagConcept() {
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
    public Map<String, String> getLabels() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IHighLevelConcept> getParents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IOSMTagKey getKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}