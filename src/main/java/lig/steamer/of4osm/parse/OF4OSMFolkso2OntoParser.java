package lig.steamer.of4osm.parse;

import java.util.Arrays;
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
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;
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
    	
    	int alreadyAddedKeyConcepts = 0;
        int alreadyAddedTagConcepts = 0;
    	
        Map<String, Set<IOSMCategoryTag>> categoryTags = folkso.getCategoryTagsByElement();
        for (Entry<String, Set<IOSMCategoryTag>> element : categoryTags.entrySet()) {
            
        	IOSMTagCombinationConceptParent[] tagCombinationParent = new OSMCategoryTagConcept[element.getValue().size()];
        	
            int j = 0;
            for (IOSMCategoryTag tag : element.getValue()) {
               
            	IOSMCategoryTagKeyConcept keyConcept = createCategoryTagKeyConcept(tag);
                if(of4osm.getOSMCategoryTagKeyConcepts().contains(keyConcept)){
                	alreadyAddedKeyConcepts++;
                }else {
                	of4osm.addConcept(keyConcept);
                }
                
                IOSMCategoryTagConcept tagConcept = createCategoryTagConcept(tag, (IOSMTagConceptParent) keyConcept);
                if(of4osm.getOSMCategoryTagConcepts().contains(tagConcept)){
                	alreadyAddedTagConcepts++;
                }else {
                	of4osm.addConcept(tagConcept);
                }

                tagCombinationParent[j] = (IOSMTagCombinationConceptParent) tagConcept;
                j++;
            }
            
            addOSMTagCombinationsConcepts(tagCombinationParent, of4osm);
            
        }
        
        LOGGER.log(Level.INFO, "Adding tags to the OF4OSM ontology is done.");
        
        LOGGER.log(Level.INFO, "Nb of IConcept instances: " + of4osm.getConcepts().size());
        LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagKeyConcept instances: " + of4osm.getOSMCategoryTagKeyConcepts().size());
        LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagKeyConcept instances already in ontology: " + alreadyAddedKeyConcepts);
		LOGGER.log(Level.INFO, "Nb of IHighLevelConcept instances: " + of4osm.getHighLevelConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagConcept instances: " + of4osm.getOSMCategoryTagConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagConcept instances already in ontology: " + alreadyAddedTagConcepts);
		LOGGER.log(Level.INFO, "Nb of IOSMTagCombinationConcept instances: " + of4osm.getOSMTagCombinationConcepts().size());

        return of4osm;
    }
    
    public static IOSMCategoryTagKeyConcept createCategoryTagKeyConcept(IOSMCategoryTag tag) {
        return new OSMCategoryTagKeyConcept(
        		OF4OSMConceptLabelizer.getLabelFromKey(tag.getKey()), 
        		tag.getKey());
    }

    public static IOSMCategoryTagConcept createCategoryTagConcept(IOSMCategoryTag tag, IOSMTagConceptParent parent) {

        if (tag instanceof IOSMSimpleCategoryTag) {
            return new OSMCategoryTagConcept(
            		OF4OSMConceptLabelizer.getLabelFromTag(tag), tag, parent);
        }
        
        if (tag instanceof IOSMMultipleCategoryTag) {
            IOSMMultipleCategoryTag multipleCatTag = (IOSMMultipleCategoryTag) tag;
            for (String v : multipleCatTag.getValue().getValues()) {
            	IOSMSimpleCategoryTag t = new OSMSimpleCategoryTag(
            			(IOSMTagSimpleKey)tag.getKey(), 
            			new OSMTagStringValue(v));
                String tagLabel = OF4OSMConceptLabelizer.getLabelFromTag(t);
                return new OSMCategoryTagConcept(tagLabel, tag, parent);
            }
        }
        
        if (tag instanceof IOSMStatefulCategoryTag) {
            return new OSMCategoryTagConcept(
            		OF4OSMConceptLabelizer.getLabelFromTag(tag), tag, parent);
        }
        
        return null;
    }

    public static void addOSMTagCombinationsConcepts(IOSMTagCombinationConceptParent[] parents, IOF4OSMOntology of4osm){
    	 
    	Set<IOSMTagCombinationConcept> tagCombinations = new HashSet<IOSMTagCombinationConcept>();
    	
    	for (int i = 2 ; i <= parents.length ; i++) {
             combinations(parents, i, 0, new IOSMTagCombinationConceptParent[i], tagCombinations);
        }
    	
    	for(IOSMTagCombinationConcept tagCombination1 : tagCombinations){
    		for(IOSMTagCombinationConcept tagCombination2 : tagCombinations){
    			if(tagCombination1.isSubClassOf(tagCombination2)){
    				tagCombination1.addParent((IOSMTagCombinationConceptParent) tagCombination2);
    			}
    		}
    		
    		of4osm.addConcept(tagCombination1);
    	}
    	
    }
    
    private static void combinations(IOSMTagCombinationConceptParent[] parents, int length, int startPosition, IOSMTagCombinationConceptParent[] result, Set<IOSMTagCombinationConcept> tagCombinations) {

        if (length == 0) {
            
            IOSMTagCombinationConcept tagCombinationConcept = new OSMTagCombinationConcept(
            		OF4OSMConceptLabelizer.getIOSMTagCombinationConceptLabel(result),
            		new HashSet<IOSMTagCombinationConceptParent>(Arrays.asList(result)));
            
            tagCombinations.add(tagCombinationConcept);
            
            LOGGER.log(Level.INFO, "Adding OSMTagCombination " + tagCombinationConcept.getDefaultLabel());
            
            return;
        }

        for (int i = startPosition ; i <= parents.length - length ; i++) {
            result[result.length - length] = parents[i];
            combinations(parents, length-1, i+1, result, tagCombinations);
        }

    }
   
}
