package lig.steamer.of4osm.util;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConcept;
import lig.steamer.of4osm.core.onto.meta.impl.HighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMStatefulCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMTagStatefulKeyConcept;

import org.apache.commons.lang3.text.WordUtils;
import org.semanticweb.owlapi.model.IRI;


public final class OF4OSMConceptFactory {
    
    public static IOSMTagSimpleKeyConcept createOSMTagSimpleKeyConcept(IOSMTagSimpleKey key){
    	String label = normalize(key.getValue());
    	IOSMTagSimpleKeyConcept concept = new OSMTagSimpleKeyConcept(
    			IRI.create(OF4OSMVocabulary.OSMTAGSIMPLEKEYCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), key);
    	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	return concept;
    }
    
    public static IOSMTagStatefulKeyConcept createOSMTagStatefulKeyConcept(IOSMTagStatefulKey key){
    	String label = normalize(key.getState());
    	label += normalize(key.getValue());
    	IOSMTagStatefulKeyConcept concept = new OSMTagStatefulKeyConcept(
    			IRI.create(OF4OSMVocabulary.OSMTAGSTATEFULKEYCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), key);
    	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	return concept;
    }
    
    public static IOSMStatefulCategoryTagConcept createOSMStatefulCategoryTagConcept(IOSMStatefulCategoryTag tag, IOSMStatefulTagConceptParent parent){
		String label = normalize(tag.getKey().getState());
    	label += normalize(tag.getValue().getValue());
    	label += normalize(tag.getKey().getValue());
    	IOSMStatefulCategoryTagConcept concept = new OSMStatefulCategoryTagConcept(
    			IRI.create(OF4OSMVocabulary.OSMSTATEFULTAGCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), tag, parent);
    	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	return concept;
    }
    
    public static IOSMSimpleCategoryTagConcept createOSMSimpleCategoryTagConcept(IOSMSimpleCategoryTag tag, IOSMStatelessTagConceptParent parent){
		String label = normalize(tag.getValue().getValue()); 
    	label += normalize(tag.getKey().getValue());
    	IOSMSimpleCategoryTagConcept concept = new OSMSimpleCategoryTagConcept(
    			IRI.create(OF4OSMVocabulary.OSMSTATELESSTAGCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), tag, parent);
    	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
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
