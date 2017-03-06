package lig.steamer.of4osm.core.folkso;

import java.util.Map;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;

/**
 *
 * @author amehiris
 */
public interface IOF4OSMFolksonomy {

	/**
	 * Returns a Map of IOSMTags grouped by element id.
	 * @return the map
	 */
    public Map<String, Set<? extends IOSMTag>> getTagsByElement();
    
    /**
     * Gets IOSMTags by the given type. 
     * @param type, the type of tags
     * @return the set of IOSMTags
     */
    public Map<? extends IOSMTag, Integer> getTagsByType(Class<? extends IOSMTag> type);
    
    /**
     * Adds the given IOSMTags to the Map at the element id.
     * @param elementId, the element id
     * @param tags, the tags to be added
     */
    public void addTagsByElement(String elementId, Set<? extends IOSMTag> tags);
    
    /**
     * Gets the number of occurrences of a given tag in the IOF4OSMFolksonomy.
     * @param tag, the tag to be looked for
     * @return the number of occurrences
     */
    public int getOccurrences(IOSMTag tag);
    
    /**
     * Gets the total number of tags in the IOF4OSMFolksonomy.
     * @return the number of tags
     */
    public int getNbOfTags();
    
    /**
     * Gets the number of tags for a given type.
     * @param type, the type of the counted tags 
     * @return the number of tags of the given type
     */
    public int getNbOfTagsByType(Class<? extends IOSMTag> type);

}