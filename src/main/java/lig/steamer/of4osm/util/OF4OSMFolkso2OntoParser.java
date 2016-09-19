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
public class OF4OSMFolkso2OntoParser {

    public OF4OSMFolkso2OntoParser() {
    }

    public OF4OSMOntology parse(OF4OSMFolkso folkso) {

        OF4OSMOntology onto = new OF4OSMOntology();

        addMapFeaturesHierarchy(onto, folkso);
        addKeyTagHierarchy(onto, folkso);
        addTagCombinations(onto, folkso);

        return onto;
    }
    
    private OF4OSMOntology addMapFeaturesHierarchy(OF4OSMOntology onto, OF4OSMFolkso folkso){
        return onto;
    }
    
    private OF4OSMOntology addKeyTagHierarchy(OF4OSMOntology onto, OF4OSMFolkso folkso){

        for (Map.Entry<IOSMSimpleCategoryTag, Integer> entry : folkso.getSimpleCategoryTags().entrySet()) {

            IOSMCategoryTagKeyConcept tagKeyConcept = new OSMCategoryTagKeyConcept(entry.getKey().getKey());
            onto.addConcept(tagKeyConcept);
            IOSMCategoryTagConcept categoryTagConcept = new OSMCategoryTagConcept(entry.getKey(), tagKeyConcept);
            onto.addConcept(categoryTagConcept);
        }

        return onto;
    }
    
    private OF4OSMOntology addTagCombinations(OF4OSMOntology onto, OF4OSMFolkso folkso){
        return onto;
    }
}
