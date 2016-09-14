package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Map;
import java.util.Set;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.IOSMNumericPropertyTag;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMDiscretizedOSMNumericPropertyTagConcept;

/**
 * 
 */
public class OSMDiscretizedOSMNumericPropertyTagConcept extends OSMDiscretizedOSMPropertyTagConcept implements IOSMDiscretizedOSMNumericPropertyTagConcept {

    /**
     * Default constructor
     */
    public OSMDiscretizedOSMNumericPropertyTagConcept() {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> getLabels() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IHighLevelConcept> getParents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}