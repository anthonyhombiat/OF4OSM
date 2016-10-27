package lig.steamer.of4osm.parse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.time.DurationFormatUtils;

import lig.steamer.of4osm.IOF4OSMFolksonomy;
import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;
import lig.steamer.of4osm.util.OF4OSMConceptFactory;

/**
 *
 * @author amehiris
 */
public final class OF4OSMFolkso2OntoParser {

	private static final Logger LOGGER = Logger.getLogger(OF4OSMFolkso2OntoParser.class.getName());
	
    public static void addConceptsFromFolkso(IOF4OSMOntology of4osm, IOF4OSMFolksonomy folkso) {

    	final long t0 = System.currentTimeMillis();
    	LOGGER.log(Level.INFO, "Adding tags to the OF4OSM ontology...");
    	
        for (Entry<String, Set<IOSMCategoryTag>> element : folkso.getCategoryTagsByElement().entrySet()) {
            
        	Set<IOSMTagCombinationConceptParent> tagCombinationParents = new HashSet<IOSMTagCombinationConceptParent>();

            for (IOSMCategoryTag tag : element.getValue()) {
               
            	IOSMCategoryTagKeyConcept keyConcept = OF4OSMConceptFactory.createOSMCategoryTagKeyConcept(tag.getKey());
            	of4osm.addConcept(keyConcept);
                
            	if (tag instanceof IOSMMultipleCategoryTag) {
                    IOSMMultipleCategoryTag multipleCatTag = (IOSMMultipleCategoryTag) tag;
                    for (String v : multipleCatTag.getValue().getValues()) {
                    	IOSMSimpleCategoryTag t = new OSMSimpleCategoryTag(
                    			(IOSMTagSimpleKey)tag.getKey(), 
                    			new OSMTagStringValue(v));
                    	IOSMCategoryTagConcept tagConcept = OF4OSMConceptFactory.createOSMCategoryTagConcept(t, (IOSMTagConceptParent) keyConcept);
                    	of4osm.addConcept(tagConcept);
                    	tagCombinationParents.add((IOSMTagCombinationConceptParent) tagConcept);
                    }
                } else {
                	IOSMCategoryTagConcept tagConcept = OF4OSMConceptFactory.createOSMCategoryTagConcept(tag, (IOSMTagConceptParent) keyConcept);
                	of4osm.addConcept(tagConcept);
                	tagCombinationParents.add((IOSMTagCombinationConceptParent) tagConcept);
                }
            }
            
            addOSMTagCombinationsConcepts(tagCombinationParents, of4osm);
        }
        
        final long t1 = System.currentTimeMillis();
        LOGGER.log(Level.INFO, "Adding tags to the OF4OSM ontology is done (" + DurationFormatUtils.formatDurationHMS(t1 - t0) + ").");
        
        LOGGER.log(Level.INFO, "Nb of IConcept instances: " + of4osm.getConcepts().size());
        LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagKeyConcept instances: " + of4osm.getOSMCategoryTagKeyConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IHighLevelConcept instances: " + of4osm.getHighLevelConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IOSMCategoryTagConcept instances: " + of4osm.getOSMCategoryTagConcepts().size());
		LOGGER.log(Level.INFO, "Nb of IOSMTagCombinationConcept instances: " + of4osm.getOSMTagCombinationConcepts().size());

    }

    private static void addOSMTagCombinationsConcepts(Set<IOSMTagCombinationConceptParent> parents, IOF4OSMOntology of4osm){
    	 
    	Set<IOSMTagCombinationConcept> tagCombinations = new HashSet<IOSMTagCombinationConcept>();
    	
    	IOSMTagCombinationConceptParent[] parentsArray = parents.toArray(new IOSMTagCombinationConceptParent[parents.size()]);
    	for (int i = 2 ; i <= parentsArray.length ; i++) {
             combinations(parentsArray, i, 0, new IOSMTagCombinationConceptParent[i], tagCombinations);
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
            
            IOSMTagCombinationConcept tagCombinationConcept = OF4OSMConceptFactory.createOSMTagCombinationConcept(
            		new HashSet<IOSMTagCombinationConceptParent>(Arrays.asList(result)));
            
            tagCombinations.add(tagCombinationConcept);
            
            return;
        }

        for (int i = startPosition ; i <= parents.length - length ; i++) {
            result[result.length - length] = parents[i];
            combinations(parents, length-1, i+1, result, tagCombinations);
        }

    }
   
}
