package lig.steamer.of4osm.onto.meta;

import java.util.Set;

/**
 * 
 */
public interface IConcept {


    /**
     * @return
     */
    public Set<String> getLabels();

    /**
     * @return
     */
    public Set<? extends IConcept> getParents();

}