package lig.steamer.of4osm.folkso.tag.component;

import java.util.Set;

/**
 * 
 */
public interface IOSMTagComplexKey extends IOSMTagKey {


    /**
     * @return
     */
    public IOSMTagSimpleKey getKey();

    /**
     * @return
     */
    public Set<String> getValues();

}