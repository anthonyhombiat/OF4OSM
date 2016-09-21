package lig.steamer.of4osm.util;

import java.util.Map;
import java.util.Map.Entry;
import lig.steamer.of4osm.IOF4OSMFolkso;
import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagKeyConcept;
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

        Map<IOSMTag, Integer> catTags = folkso.getTagsByType(IOSMCategoryTag.class);

        for (Entry<IOSMTag, Integer> entry : catTags.entrySet()) {
            IOSMCategoryTag tag = (IOSMCategoryTag) entry.getKey();

            String keyLabel = WordUtils.capitalize(tag.getKey().getValue());
            IOSMCategoryTagKeyConcept tagKeyConcept = new OSMCategoryTagKeyConcept(keyLabel, tag.getKey());
            onto.addConcept(tagKeyConcept, entry.getValue());

            if (IOSMSimpleCategoryTag.class.isInstance(tag)) {
                String tagLabel = OntoLabelExtractor.getLabelFromIOSMSimpleCategoryTag((IOSMSimpleCategoryTag) tag);
                IOSMCategoryTagConcept categoryTagConcept = new OSMCategoryTagConcept(tagLabel, tag, tagKeyConcept);
                onto.addConcept(categoryTagConcept, entry.getValue());
            }

            if (IOSMMultipleCategoryTag.class.isInstance(tag)) {
                IOSMMultipleCategoryTag multipleCatTag = (IOSMMultipleCategoryTag) tag;
                for (int i = 0; i < multipleCatTag.getValue().getValues().length; i++) {
                    String tagLabel = OntoLabelExtractor.getLabelFromIOSMMultipleCategoryTag((IOSMMultipleCategoryTag) tag, i);
                    IOSMCategoryTagConcept categoryTagConcept = new OSMCategoryTagConcept(tagLabel, tag, tagKeyConcept);
                    onto.addConcept(categoryTagConcept, entry.getValue());
                }
            }

            if (IOSMStatefulCategoryTag.class.isInstance(tag)) {
                String tagLabel = OntoLabelExtractor.getLabelFromIOSMStatefulCategoryTag((IOSMStatefulCategoryTag) tag);
                IOSMCategoryTagConcept categoryTagConcept = new OSMCategoryTagConcept(tagLabel, tag, tagKeyConcept);
                onto.addConcept(categoryTagConcept, entry.getValue());
            }
        }

        return onto;
    }

    private static IOF4OSMOntology addTagCombinations(IOF4OSMOntology onto, IOF4OSMFolkso folkso) {

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
}
