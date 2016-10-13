package lig.steamer.of4osm.core.folkso.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lig.steamer.of4osm.IOF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;

/**
 *
 * @author amehiris
 */
public class OF4OSMFolksonomy implements IOF4OSMFolksonomy {

    private Map<String, Set<IOSMTag>> tags;

    public OF4OSMFolksonomy() {
        tags = new HashMap<>();
    }

    @Override
    public Map<String, Set<IOSMTag>> getTags() {
        return tags;
    }

    @Override
    public Map< IOSMTag, Integer> getTagsByType(Class<? extends IOSMTag> type) {

        Map< IOSMTag, Integer> tags = new HashMap<>();

        // for each element
        for (Entry<String, Set<IOSMTag>> entry : this.tags.entrySet()) {
            // for each tag of the current element
            for (IOSMTag tag : entry.getValue()) {
                if (type.isInstance(tag)) {
                    tags.put(tag, getOccurrences(tag));
                }
            }
        }
        return tags;
    }

    @Override
    public int getOccurrences(IOSMTag tag) {
        int nbOcc = 0;
        for (Entry<String, Set<IOSMTag>> entry : tags.entrySet()) {
            for (IOSMTag currTag : entry.getValue()) {
                if (tag.equals(currTag)) {
                    nbOcc++;
                }
            }
        }
        return nbOcc;
    }

    public void addTags(String elementId, Set<IOSMTag> tags) {
        this.tags.put(elementId, tags);
    }

}
