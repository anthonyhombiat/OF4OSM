package lig.steamer.of4osm.util;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.impl.HighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMTagCombinationConcept;

import org.apache.commons.lang3.text.WordUtils;
import org.semanticweb.owlapi.model.IRI;


public final class OF4OSMConceptFactory {
    
    public static IOSMCategoryTagKeyConcept createOSMCategoryTagKeyConcept(IOSMTagKey key){
    	
    	IOSMCategoryTagKeyConcept concept = null;
    	String label = "";
    	
    	if(key instanceof IOSMTagSimpleKey){
    		label = normalize(key.getValue());
    		concept = new OSMCategoryTagKeyConcept(
        			IRI.create(OF4OSMVocabulary.OSMTAGKEYCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), key);
        	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	} else if(key instanceof IOSMTagComplexKey){
    		IOSMTagComplexKey complexKey = (IOSMTagComplexKey) key;
        	for(String prefix : complexKey.getPrefixes())
        		label += normalize(prefix);
        	label += normalize(key.getValue());
    		concept = new OSMCategoryTagKeyConcept(
        			IRI.create(OF4OSMVocabulary.OSMTAGKEYCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), complexKey);
        	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	} else if(key instanceof IOSMTagLocalizedKey){
    		label = normalize(key.getValue());
    		concept = new OSMCategoryTagKeyConcept(
        			IRI.create(OF4OSMVocabulary.OSMTAGKEYCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), key);
        	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	} else if(key instanceof IOSMTagStatefulKey){
    		IOSMTagStatefulKey statefulKey = (IOSMTagStatefulKey) key;
    		label += normalize(statefulKey.getState());
        	label += normalize(statefulKey.getValue());
    		concept = new OSMCategoryTagKeyConcept(
        			IRI.create(OF4OSMVocabulary.OSMTAGKEYCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), statefulKey);
        	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
        	IHighLevelConcept statefulConcept = OF4OSMConceptFactory.createHighLevelConcept(statefulKey.getState() + "Entity");
        	concept.addParent(statefulConcept);
    	}
    	
    	return concept;
    }
    
    public static IOSMCategoryTagConcept createOSMCategoryTagConcept(IOSMCategoryTag tag, IOSMTagConceptParent parent){
    	
    	IOSMCategoryTagConcept concept = null;
    	String label = "";
    	
    	if(tag instanceof IOSMSimpleCategoryTag){
    		IOSMSimpleCategoryTag simpleTag = (IOSMSimpleCategoryTag) tag;
    		label += normalize(simpleTag.getValue().getValue()); 
        	label += normalize(simpleTag.getKey().getValue());
    		concept = new OSMCategoryTagConcept(
        			IRI.create(OF4OSMVocabulary.OSMTAGCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), simpleTag, parent);
        	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	} else if(tag instanceof IOSMStatefulCategoryTag){
    		IOSMStatefulCategoryTag statefulTag = (IOSMStatefulCategoryTag) tag;
    		label += normalize(statefulTag.getKey().getState());
        	label += normalize(statefulTag.getValue().getValue());
        	label += normalize(statefulTag.getKey().getValue());
    		concept = new OSMCategoryTagConcept(
        			IRI.create(OF4OSMVocabulary.OSMTAGCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), statefulTag, parent);
        	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	} 
    	
    	return concept;
    }
    
public static IOSMTagCombinationConcept createOSMTagCombinationConcept(Set<IOSMTagCombinationConceptParent> parents){
		
		String label = "";
		for(IOSMTagCombinationConceptParent parent : parents){
			label += parent.getDefaultLabel();
		}
		
		IOSMTagCombinationConcept concept = new OSMTagCombinationConcept(
				IRI.create(OF4OSMVocabulary.OSMTAGCOMBINATION_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), parents);
		
		concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
		
		return concept;
	
	}
    
	public static IHighLevelConcept createHighLevelConcept(String label){
    	IHighLevelConcept concept = new HighLevelConcept(
    			IRI.create(OF4OSMVocabulary.HIGHLEVELCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + normalize(label)));
    	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, normalize(label));
    	return concept;
	}
    
	private static String normalize(String s){
		String res = WordUtils.capitalize(s);
		res = WordUtils.capitalize(res, '_');
		res = WordUtils.capitalize(res, ',');
		res = res.replace(" ", "");
		res = res.replace("_", "");
		res = res.replace(",", "");
		return res;
	}
    
}
