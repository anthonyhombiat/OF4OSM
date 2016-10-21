package lig.steamer.of4osm;

import java.util.Map;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;

/**
 *
 * @author amehiris
 */
public interface IOF4OSMFolksonomy {

    public Map<String, Set<? extends IOSMTag>> getTagsByElement();

    public Map<String, Set<IOSMCategoryTag>> getCategoryTagsByElement();
    
    public Map<? extends IOSMTag, Integer> getTagsByType(Class<? extends IOSMTag> type);
    
    public void addTagsByElement(String elementId, Set<? extends IOSMTag> tags);
    
    public int getOccurrences(IOSMTag tag);
    
    public int getNbOfTags();
    
    public int getNbOfTagsByType(Class<? extends IOSMTag> type);

}
