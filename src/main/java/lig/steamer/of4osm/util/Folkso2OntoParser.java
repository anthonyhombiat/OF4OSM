package lig.steamer.of4osm.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lig.steamer.of4osm.IOF4OSMFolkso;
import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMTagCombinationConcept;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author amehiris
 */
public final class Folkso2OntoParser {

    public static IOF4OSMOntology addConceptsFromFolkso(IOF4OSMOntology onto, IOF4OSMFolkso folkso) {

        onto = addKeyTagHierarchy(onto, folkso);
        onto = addTagCombinations(onto, folkso);

        return onto;
    }

    private static IOF4OSMOntology addKeyTagHierarchy(IOF4OSMOntology onto, IOF4OSMFolkso folkso) {

//        Map<IOSMTag, Integer> catTags = folkso.getTagsByType(IOSMCategoryTag.class);
//
//        for (Entry<IOSMTag, Integer> entry : catTags.entrySet()) {
//            IOSMCategoryTag tag = (IOSMCategoryTag) entry.getKey();
//
//            IOSMCategoryTagKeyConcept tagKeyConcept = CreateCategoryTagKeyConcept(tag);
//            onto.addConcept(tagKeyConcept, entry.getValue());
//            IOSMCategoryTagConcept categoryTagConcept = CreateCategoryTagConcept(tag, tagKeyConcept);
//            onto.addConcept(categoryTagConcept, entry.getValue());
//        }
        Map< String, Set<IOSMCategoryTag>> categoryTags = getCategoryTagByElement(folkso);
        for (Entry< String, Set<IOSMCategoryTag>> entry : categoryTags.entrySet()) {
            IOSMTagCombinationConceptParent[] categoryTagConceptSet = new OSMCategoryTagConcept[entry.getValue().size()] ;
            int j = 0;
            for (IOSMCategoryTag tag : entry.getValue()) {
                IOSMCategoryTagKeyConcept tagKeyConcept = createCategoryTagKeyConcept(tag);
                onto.addConcept(tagKeyConcept, 1);
                IOSMCategoryTagConcept categoryTagConcept = createCategoryTagConcept(tag, tagKeyConcept);
                onto.addConcept(categoryTagConcept, 1);

                categoryTagConceptSet[j] = categoryTagConcept;
                j++;

            }
            //for (int i = 2; i < categoryTagConceptSet.length + 1; i++) {
                combinations(categoryTagConceptSet, 2, 0, new IOSMTagCombinationConcept[2], onto);
           // }
        }
        return onto;
    }

    public static void combinations(IOSMTagCombinationConceptParent[] categoryTagConceptSet, int length, int startPosition, IOSMTagCombinationConceptParent[] result, IOF4OSMOntology onto) {

        if (length == 0) {
            
            OSMTagCombinationConcept tagCombinationConcept = new OSMTagCombinationConcept();
            for (IOSMTagCombinationConceptParent s : result) {
                tagCombinationConcept.addParent(s);
            }
            System.out.println(tagCombinationConcept);
            onto.addConcept(tagCombinationConcept, 1);
            return;
        }

        for (int j = startPosition; j <= categoryTagConceptSet.length - length; j++) {
            result[result.length - length] = categoryTagConceptSet[j];
            combinations(categoryTagConceptSet, length - 1, j + 1, result, onto);
        }

    }

    public static IOSMCategoryTagKeyConcept createCategoryTagKeyConcept(IOSMCategoryTag tag) {
        String keyLabel = WordUtils.capitalize(tag.getKey().getValue());
        return new OSMCategoryTagKeyConcept(keyLabel, tag.getKey());
    }

    public static IOSMCategoryTagConcept createCategoryTagConcept(IOSMCategoryTag tag, IOSMCategoryTagKeyConcept tagKeyConcept) {

        if (IOSMSimpleCategoryTag.class.isInstance(tag)) {
            String tagLabel = OntoLabelExtractor.getLabelFromIOSMSimpleCategoryTag((IOSMSimpleCategoryTag) tag);
            return new OSMCategoryTagConcept(tagLabel, tag, tagKeyConcept);
        }
        if (IOSMMultipleCategoryTag.class.isInstance(tag)) {
            IOSMMultipleCategoryTag multipleCatTag = (IOSMMultipleCategoryTag) tag;
            for (int i = 0; i < multipleCatTag.getValue().getValues().length; i++) {
                String tagLabel = OntoLabelExtractor.getLabelFromIOSMMultipleCategoryTag((IOSMMultipleCategoryTag) tag, i);
                return new OSMCategoryTagConcept(tagLabel, tag, tagKeyConcept);
            }
        }
        if (IOSMStatefulCategoryTag.class.isInstance(tag)) {
            String tagLabel = OntoLabelExtractor.getLabelFromIOSMStatefulCategoryTag((IOSMStatefulCategoryTag) tag);
            return new OSMCategoryTagConcept(tagLabel, tag, tagKeyConcept);
        }
        return null;
    }

    private static IOF4OSMOntology addTagCombinations(IOF4OSMOntology onto, IOF4OSMFolkso folkso) {

        Map< String, Set<IOSMCategoryTag>> tags = getCategoryTagByElement(folkso);
        for (Entry<String, Set<IOSMCategoryTag>> entry : tags.entrySet()) {

        }

        /* Algo for finding permutations */
 /*
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
         */
        return onto;
    }

    static Map< String, Set<IOSMCategoryTag>> getCategoryTagByElement(IOF4OSMFolkso folkso) {
        Map< String, Set<IOSMCategoryTag>> tags = new HashMap<>();
        // for each element
        for (Entry<String, Set<IOSMTag>> entry : folkso.getTags().entrySet()) {
            // for each tag of the current element
            Set categoryTag = new HashSet();
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
