package lig.steamer.of4osm.core.onto.meta;

import java.util.Map;
import java.util.Set;

/**
 * 
 */
public interface IConcept {


    /**
     * @return
     */
    public Map<String,String> getLabels();

    /**
     * @return
     */
    public Set<? extends IConcept> getParents();

}