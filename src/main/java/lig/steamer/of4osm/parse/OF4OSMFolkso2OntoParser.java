package lig.steamer.of4osm.parse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.IOF4OSMFolksonomy;
import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMTagCombinationConcept;
import lig.steamer.of4osm.util.OF4OSMConceptLabelizer;

/**
 *
 * @author amehiris
 */
public final class OF4OSMFolkso2OntoParser {

	private static final Logger LOGGER = Logger.getLogger(OF4OSMFolkso2OntoParser.class.getName());
	
    public static IOF4OSMOntology addConceptsFromFolkso(IOF4OSMOntology of4osm, IOF4OSMFolksonomy folkso) {

    	LOGGER.log(Level.INFO, "Adding tags to the OF4OSM ontology...");
    	
    	/*
    	Map<IOSMTag, Integer> catTags = folkso.getTagsByType(IOSMCategoryTag.class);

        for (Entry<IOSMTag, Integer> entry : catTags.entrySet()) {
            IOSMCategoryTag tag = (IOSMCategoryTag) entry.getKey();

            IOSMCategoryTagKeyConcept tagKeyConcept = CreateCategoryTagKeyConcept(tag);
            onto.addConcept(tagKeyConcept, entry.getValue());
            IOSMCategoryTagConcept categoryTagConcept = CreateCategoryTagConcept(tag, tagKeyConcept);
            onto.addConcept(categoryTagConcept, entry.getValue());
        }
        */
    	
        Map<String, Set<IOSMCategoryTag>> categoryTags = getCategoryTagsByElement(folkso);
        for (Entry<String, Set<IOSMCategoryTag>> entry : categoryTags.entrySet()) {
            IOSMTagCombinationConceptParent[] categoryTagConcepts = new OSMCategoryTagConcept[entry.getValue().size()] ;
            int j = 0;
            for (IOSMCategoryTag tag : entry.getValue()) {
                IOSMCategoryTagKeyConcept tagKeyConcept = createCategoryTagKeyConcept(tag);
                of4osm.addConcept(tagKeyConcept);
                IOSMCategoryTagConcept categoryTagConcept = createCategoryTagConcept(tag, tagKeyConcept);
                of4osm.addConcept(categoryTagConcept);

                categoryTagConcepts[j] = categoryTagConcept;
                j++;
            }
            
//            for (int i = 2; i < categoryTagConceptSet.length + 1; i++) {
//                combinations(categoryTagConceptSet, 2, 0, new IOSMTagCombinationConcept[2], onto);
//            }
            
        }
        
        LOGGER.log(Level.INFO, "Adding tags to the OF4OSM ontology is done.");
        
        LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagKeyConcept instances: " + of4osm.getOSMCategoryTagKeyConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IHighLevelConcept instances: " + of4osm.getHighLevelConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagConcept instances: " + of4osm.getOSMCategoryTagConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IOSMTagCombinationConcept instances: " + of4osm.getOSMTagCombinationConcepts().size());

        return of4osm;
    }
    
    public static IOSMCategoryTagKeyConcept createCategoryTagKeyConcept(IOSMCategoryTag tag) {
        return new OSMCategoryTagKeyConcept(
        		OF4OSMConceptLabelizer.getLabelFromKey(tag.getKey()), 
        		tag.getKey());
    }

    public static IOSMCategoryTagConcept createCategoryTagConcept(IOSMCategoryTag tag, IOSMCategoryTagKeyConcept tagKeyConcept) {

        if (tag instanceof IOSMSimpleCategoryTag) {
            return new OSMCategoryTagConcept(
            		OF4OSMConceptLabelizer.getLabelFromTag(tag), tag, tagKeyConcept);
        }
        
        if (tag instanceof IOSMMultipleCategoryTag) {
            IOSMMultipleCategoryTag multipleCatTag = (IOSMMultipleCategoryTag) tag;
            for (String v : multipleCatTag.getValue().getValues()) {
            	IOSMSimpleCategoryTag t = new OSMSimpleCategoryTag(
            			(IOSMTagSimpleKey)tag.getKey(), 
            			new OSMTagStringValue(v));
                String tagLabel = OF4OSMConceptLabelizer.getLabelFromTag(t);
                return new OSMCategoryTagConcept(tagLabel, tag, tagKeyConcept);
            }
        }
        
        if (tag instanceof IOSMStatefulCategoryTag) {
            return new OSMCategoryTagConcept(
            		OF4OSMConceptLabelizer.getLabelFromTag(tag), tag, tagKeyConcept);
        }
        
        return null;
    }

    public static void combinations(IOSMTagCombinationConceptParent[] categoryTagConceptSet, int length, int startPosition, IOSMTagCombinationConceptParent[] result, IOF4OSMOntology onto) {

        if (length == 0) {
            
            OSMTagCombinationConcept tagCombinationConcept = new OSMTagCombinationConcept();
            for (IOSMTagCombinationConceptParent s : result) {
                tagCombinationConcept.addParent(s);
            }
            
            System.out.println(tagCombinationConcept);
            onto.addConcept(tagCombinationConcept);
            return;
        }

        for (int j = startPosition ; j <= categoryTagConceptSet.length - length ; j++) {
            result[result.length - length] = categoryTagConceptSet[j];
            combinations(categoryTagConceptSet, length - 1, j + 1, result, onto);
        }

    }

    /*
     * Algo for finding permutations
    private static IOF4OSMOntology addTagCombinations(IOF4OSMOntology onto, IOF4OSMFolksonomy folkso) {

    	String[] arr = {"A","B","C","D"};
			for(int i=2;i<arr.length+1;i++)
				combinations(arr, i, 0, new String[i]);
			
			public static void combinations(String[] arr, int len, int startPosition, String[] result){
				if (len == 0){
					String str = "";
					for(String s : result){
						str += s;
					}
					System.out.println(str);
					return;
				}       
				for (int i = startPosition; i <= arr.length-len; i++){
					result[result.length - len] = arr[i];
					combinations(arr, len-1, i+1, result);
				}
			}
        return onto;
    }
    */

    private static Map< String, Set<IOSMCategoryTag>> getCategoryTagsByElement(IOF4OSMFolksonomy folkso) {
        Map< String, Set<IOSMCategoryTag>> tags = new HashMap<>();
        // for each element
        for (Entry<String, Set<IOSMTag>> entry : folkso.getTags().entrySet()) {
            // for each tag of the current element
            Set categoryTag = new HashSet<>();
            for (IOSMTag tag : entry.getValue()) {
                if (IOSMCategoryTag.class.isInstance(tag)) {
                    categoryTag.add(tag);
                }
            }
            tags.put(entry.getKey(), categoryTag);
        }
        return tags;
    }
   
}
