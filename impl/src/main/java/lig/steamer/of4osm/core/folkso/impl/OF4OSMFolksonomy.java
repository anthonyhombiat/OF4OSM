package lig.steamer.of4osm.core.folkso.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.IOF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;

/**
 *
 * @author amehiris
 */
public class OF4OSMFolksonomy implements IOF4OSMFolksonomy {

    private Map<String, Set<? extends IOSMTag>> tagsByElement;

    public OF4OSMFolksonomy() {
        tagsByElement = new HashMap<>();
    }

    @Override
    public Map<String, Set<? extends IOSMTag>> getTagsByElement() {
        return tagsByElement;
    }

    @Override
    public Map<IOSMTag, Integer> getTagsByType(Class<? extends IOSMTag> type) {

        Map< IOSMTag, Integer> tags = new HashMap<>();

        for (Entry<String, Set<? extends IOSMTag>> element : tagsByElement.entrySet()) {
            for (IOSMTag tag : element.getValue()) {
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
        for (Entry<String, Set<? extends IOSMTag>> element : tagsByElement.entrySet()) {
            for (IOSMTag currTag : element.getValue()) {
                if (tag.equals(currTag)) {
                    nbOcc++;
                }
            }
        }
        
        return nbOcc;
    }

    @Override
    public void addTagsByElement(String elementId, Set<? extends IOSMTag> tags) {
        tagsByElement.put(elementId, tags);
    }

	@Override
	public int getNbOfTags() {
		int nbOfTags = 0;
		for(Entry<String, Set<? extends IOSMTag>> element : tagsByElement.entrySet()){
			nbOfTags += element.getValue().size();
		}
		return nbOfTags;
	}

	@Override
	public int getNbOfTagsByType(Class<? extends IOSMTag> type) {
		int nbOfTags = 0;
		for(Entry<String, Set<? extends IOSMTag>> element : tagsByElement.entrySet()){
			for(IOSMTag tag : element.getValue()){
				if(type.isInstance(tag)){
					nbOfTags ++;
				}
			}
		}
		return nbOfTags;
	}
    
}