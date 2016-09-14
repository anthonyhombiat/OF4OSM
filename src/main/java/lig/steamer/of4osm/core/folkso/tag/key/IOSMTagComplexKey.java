package lig.steamer.of4osm.core.folkso.tag.key;

import java.util.Set;

/**
 * 
 */
public interface IOSMTagComplexKey extends IOSMTagKey {
    /**
     * @return
     */
    public Set<String> getPrefixes();

}