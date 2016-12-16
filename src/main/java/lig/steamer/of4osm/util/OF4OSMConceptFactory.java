package lig.steamer.of4osm.util;

import java.util.Set;

import org.apache.commons.lang3.text.WordUtils;
import org.semanticweb.owlapi.model.IRI;

import lig.steamer.of4osm.core.folkso.tag.IOSMBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMBooleanPropertyTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMStatefulTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMStatelessTagConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagStatefulKeyConcept;
import lig.steamer.of4osm.core.onto.meta.impl.HighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMBooleanPropertyTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMSimpleCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMStatefulCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMTagSimpleKeyConcept;
import lig.steamer.of4osm.core.onto.meta.impl.OSMTagStatefulKeyConcept;


public final class OF4OSMConceptFactory {
    
	/**********/
	/** KEYS **/
	/**********/
	
	/**
	 * Creates an IOSMTagSimpleKeyConcept out of an IOSMTagSimpleKey.
	 * @param key, the IOSMTagSimpleKey from which the Concept is extracted
	 * @return the IOSMTagSimpleKeyConcept
	 */
    public static IOSMTagSimpleKeyConcept createOSMTagSimpleKeyConcept(IOSMTagSimpleKey key){
    	String label = normalize(key.getValue());
    	IOSMTagSimpleKeyConcept concept = new OSMTagSimpleKeyConcept(
    			IRI.create(OF4OSMVocabulary.OSMTAGSIMPLEKEYCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), key);
    	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	return concept;
    }
    
    /**
	 * Creates an IOSMTagStatefulKeyConcept out of an IOSMTagStatefulKey.
	 * @param key, the IOSMTagStatefulKey from which the Concept is extracted
	 * @return the IOSMTagStatefulKeyConcept
	 */
    public static IOSMTagStatefulKeyConcept createOSMTagStatefulKeyConcept(IOSMTagStatefulKey key){
    	String label = normalize(key.getState());
    	label += normalize(key.getValue());
    	IOSMTagStatefulKeyConcept concept = new OSMTagStatefulKeyConcept(
    			IRI.create(OF4OSMVocabulary.OSMTAGSTATEFULKEYCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), key);
    	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	return concept;
    }
    
    /**********/
    /** TAGS **/
    /**********/
    
    /**
	 * Creates an IOSMStatefulCategoryTagConcept out of an IOSMStatefulCategoryTag.
	 * @param tag, the IOSMStatefulCategoryTag from which the Concept is extracted
	 * @param parent, the IOSMStatefulTagConceptParent parent
	 * @return the IOSMStatefulCategoryTagConcept
	 */
    public static IOSMStatefulCategoryTagConcept createOSMStatefulCategoryTagConcept(IOSMStatefulCategoryTag tag, IOSMStatefulTagConceptParent parent){
		String label = normalize(tag.getKey().getState());
    	label += normalize(tag.getValue().getValue());
    	label += normalize(tag.getKey().getValue());
    	IOSMStatefulCategoryTagConcept concept = new OSMStatefulCategoryTagConcept(
    			IRI.create(OF4OSMVocabulary.OSMSTATEFULTAGCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), tag, parent);
    	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	return concept;
    }
    
    /**
	 * Creates an IOSMSimpleCategoryTagConcept out of an IOSMSimpleCategoryTag.
	 * @param tag, the IOSMSimpleCategoryTag from which the Concept is extracted
	 * @param parent, the IOSMStatelessTagConceptParent parent
	 * @return the IOSMSimpleCategoryTagConcept
	 */
    public static IOSMSimpleCategoryTagConcept createOSMSimpleCategoryTagConcept(IOSMSimpleCategoryTag tag, IOSMStatelessTagConceptParent parent){
		String label = normalize(tag.getValue().getValue()); 
    	label += normalize(tag.getKey().getValue());
    	IOSMSimpleCategoryTagConcept concept = new OSMSimpleCategoryTagConcept(
    			IRI.create(OF4OSMVocabulary.OSMSTATELESSTAGCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), tag, parent);
    	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
    	return concept;
    }
    
    /**
	 * Creates an IOSMTagCombinationConcept out of a set of IOSMTagCombinationConceptParent parents.
	 * @param parents, the IOSMTagCombinationConceptParent parents
	 * @return the IOSMTagCombinationConcept
	 */
    public static IOSMTagCombinationConcept createOSMTagCombinationConcept(Set<IOSMTagCombinationConceptParent> parents){
		
		String label = "";
		for(IOSMTagCombinationConceptParent parent : parents){
			label += parent.getDefaultLabel();
		}
		
		IOSMTagCombinationConcept concept = new OSMTagCombinationConcept(
				IRI.create(OF4OSMVocabulary.OSMTAGCOMBINATIONCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label), parents);
		
		concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
		
		return concept;
	}
    
    /**
	 * Creates an IHighLevelConcept from a label.
	 * @param label, the String which will be the concept label
	 * @return the IHighLevelConcept
	 */
	public static IHighLevelConcept createHighLevelConcept(String label){
    	IHighLevelConcept concept = new HighLevelConcept(
    			IRI.create(OF4OSMVocabulary.HIGHLEVELCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + normalize(label)));
    	concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, normalize(label));
    	return concept;
	}
	
	/**
	 * Creates an IHighLevelConcept from a label.
	 * @param label, the String which will be the concept label
	 * @return the IHighLevelConcept
	 */
	public static IOSMBooleanPropertyTagConcept createOSMBooleanPropertyTagConcept(IOSMBooleanValuePropertyTag tag){
		IOSMTagKey key = tag.getKey();
		String label = "Has" + normalize(key.getValue()) + "PropertyEntity";
		IOSMBooleanPropertyTagConcept concept = new OSMBooleanPropertyTagConcept(IRI.create(OF4OSMVocabulary.OSMBOOLEANPROPERTYTAGCONCEPT_IRI + OF4OSMVocabulary.IRI_SEPARATOR + label));
		concept.addLabel(OF4OSMVocabulary.DEFAULT_LANG, label);
		return concept;
	}
    
	/**
	 * Normalizes a String for concepts labels.
	 * @param s, the String to normalize
	 * @return the normalized String
	 */
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