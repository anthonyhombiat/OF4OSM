package lig.steamer.of4osm.parse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.core.folkso.IOF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.onto.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConceptParent;
import lig.steamer.of4osm.util.OF4OSMConceptFactory;

import org.apache.commons.lang3.time.DurationFormatUtils;

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
               
            	if (tag instanceof IOSMMultipleCategoryTag) {
            		
            		IOSMTagSimpleKeyConcept keyConcept = OF4OSMConceptFactory.createOSMTagSimpleKeyConcept((IOSMTagSimpleKey) tag.getKey());
                	of4osm.addConcept(keyConcept);
            		
                    IOSMMultipleCategoryTag multipleCatTag = (IOSMMultipleCategoryTag) tag;
                    for (String v : multipleCatTag.getValue().getValues()) {
                    	IOSMSimpleCategoryTag t = new OSMSimpleCategoryTag(
                    			(IOSMTagSimpleKey)tag.getKey(), 
                    			new OSMTagStringValue(v));
                    	IOSMSimpleCategoryTagConcept tagConcept = OF4OSMConceptFactory.createOSMSimpleCategoryTagConcept(t, (IOSMStatelessTagConceptParent) keyConcept);
                    	of4osm.addConcept(tagConcept);
                    	tagCombinationParents.add((IOSMTagCombinationConceptParent) tagConcept);
                    }
                    
                } else if (tag instanceof IOSMStatefulCategoryTag){
                	// ex.: disused:shop=bakery
                	
                	// disused:shop=bakery
                	IOSMStatefulCategoryTag statefulTag = (IOSMStatefulCategoryTag) tag;
                	
                	// shop=bakery
                	IOSMSimpleCategoryTag simpleTag = new OSMSimpleCategoryTag(
                			new OSMTagSimpleKey(statefulTag.getKey().getValue(), ""),
                			statefulTag.getValue());
                	
                	// Shop
                	IOSMTagSimpleKeyConcept simpleKeyConcept = OF4OSMConceptFactory.createOSMTagSimpleKeyConcept(simpleTag.getKey());
                	of4osm.addConcept(simpleKeyConcept);
                	
                	// BakeryShop (parent: Shop)
                	IOSMSimpleCategoryTagConcept simpleTagConcept = OF4OSMConceptFactory.createOSMSimpleCategoryTagConcept(simpleTag, (IOSMStatelessTagConceptParent) simpleKeyConcept);
                	of4osm.addConcept(simpleTagConcept);
                	
                	// DisusedEntity
                	IHighLevelConcept statefulHighLevelConcept = OF4OSMConceptFactory.createHighLevelConcept(statefulTag.getKey().getState() + "Entity");
                	
                	// DisusedShop (parent: DisusedEntity & Shop)
                	IOSMTagStatefulKeyConcept statefulKeyConcept = OF4OSMConceptFactory.createOSMTagStatefulKeyConcept(statefulTag.getKey());
                	statefulKeyConcept.addParent((IOSMTagStatefulKeyConceptParent) statefulHighLevelConcept);
                	statefulKeyConcept.addParent((IOSMTagStatefulKeyConceptParent) simpleKeyConcept);
                	of4osm.addConcept(statefulKeyConcept);
          
                	// DisusedBakeryShop (parents: DisusedShop & BakeryShop)
                	IOSMStatefulCategoryTagConcept statefulTagConcept = OF4OSMConceptFactory.createOSMStatefulCategoryTagConcept(statefulTag, (IOSMStatefulTagConceptParent) statefulKeyConcept);
                	statefulTagConcept.addParent((IOSMStatefulTagConceptParent) simpleTagConcept);
                	of4osm.addConcept(statefulTagConcept);
                	
                	tagCombinationParents.add((IOSMTagCombinationConceptParent) statefulTagConcept);
                } else {
                	
                	IOSMTagSimpleKeyConcept keyConcept = OF4OSMConceptFactory.createOSMTagSimpleKeyConcept((IOSMTagSimpleKey) tag.getKey());
                	of4osm.addConcept(keyConcept);
                	
                	IOSMSimpleCategoryTagConcept tagConcept = OF4OSMConceptFactory.createOSMSimpleCategoryTagConcept((IOSMSimpleCategoryTag) tag, (IOSMStatelessTagConceptParent) keyConcept);
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
