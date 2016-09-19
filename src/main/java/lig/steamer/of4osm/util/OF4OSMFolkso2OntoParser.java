package lig.steamer.of4osm.util;

import java.util.Map;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagKeyConcept;

/**
 *
 * @author amehiris
 */
public final class OF4OSMFolkso2OntoParser {

    public static OF4OSMOntology parse(OF4OSMFolkso folkso) {

        OF4OSMOntology onto = new OF4OSMOntology();

        addMapFeaturesHierarchy(onto, folkso);
        addKeyTagHierarchy(onto, folkso);
        addTagCombinations(onto, folkso);

        return onto;
    }
    
    private static OF4OSMOntology addMapFeaturesHierarchy(OF4OSMOntology onto, OF4OSMFolkso folkso){
        return onto;
    }
    
    private static OF4OSMOntology addKeyTagHierarchy(OF4OSMOntology onto, OF4OSMFolkso folkso){

        for (Map.Entry<IOSMSimpleCategoryTag, Integer> entry : folkso.getSimpleCategoryTags().entrySet()) {

            IOSMCategoryTagKeyConcept tagKeyConcept = new OSMCategoryTagKeyConcept(entry.getKey().getKey());
            onto.addConcept(tagKeyConcept);
            IOSMCategoryTagConcept categoryTagConcept = new OSMCategoryTagConcept(entry.getKey(), tagKeyConcept);
            onto.addConcept(categoryTagConcept);
        }

        return onto;
    }
    
    private static OF4OSMOntology addTagCombinations(OF4OSMOntology onto, OF4OSMFolkso folkso){
        
    	/* Algo for finding permutations */
    	/*
    	String[] arr = {"A","B","C","4" };
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
