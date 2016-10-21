package lig.steamer.of4osm.util;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
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
	
	public static final String OF4OSM_NAMESPACE = "http://steamer.imag.fr/of4osm";
	
	public static final String OF4OSM_HIGHLEVELCONCEPT_PATH = "/highlevelconcept";
	public static final String OF4OSM_OSMTAGKEYCONCEPT_PATH = "/osmtagkeyconcept";
	public static final String OF4OSM_OSMTAGCONCEPT_PATH = "/osmtagconcept";
	public static final String OF4OSM_OSMTAGCONBINATION_PATH = "/osmtagcombination";
	
	public static final String OF4OSM_SEPARATOR = "#";
	
	public static final String OF4OSM_DEFAULT_LANG = "EN";
	
	public static IOSMTagCombinationConcept createOSMTagCombinationConcept(Set<IOSMTagCombinationConceptParent> parents){
		
		String label = "";
		for(IOSMTagCombinationConceptParent parent : parents){
			label += parent.getDefaultLabel();
		}
		
		IOSMTagCombinationConcept concept = new OSMTagCombinationConcept(
				IRI.create(OF4OSM_NAMESPACE + OF4OSM_OSMTAGCONBINATION_PATH + OF4OSM_SEPARATOR + label), parents);
		
		concept.addLabel(OF4OSM_DEFAULT_LANG, label);
		
		return concept;
	
	}
    
	public static IHighLevelConcept createHighLevelConcept(String label){
    	IHighLevelConcept concept = new HighLevelConcept(
    			IRI.create(OF4OSM_NAMESPACE + OF4OSM_HIGHLEVELCONCEPT_PATH + OF4OSM_SEPARATOR + normalize(label)));
    	concept.addLabel(OF4OSM_DEFAULT_LANG, normalize(label));
    	return concept;
	}
    
    public static IOSMCategoryTagKeyConcept createOSMCategoryTagKeyConcept(IOSMTagKey key){
    	String label = getLabelFromKey(key);
    	IOSMCategoryTagKeyConcept concept = new OSMCategoryTagKeyConcept(
    			IRI.create(OF4OSM_NAMESPACE + OF4OSM_OSMTAGKEYCONCEPT_PATH + OF4OSM_SEPARATOR + label), key);
    	concept.addLabel(OF4OSM_DEFAULT_LANG, label);
    	return concept;
    }
    
    public static IOSMCategoryTagConcept createOSMCategoryTagConcept(IOSMCategoryTag tag, IOSMTagConceptParent parent){
    	String label = getLabelFromTag(tag);
    	IOSMCategoryTagConcept concept = new OSMCategoryTagConcept(
    			IRI.create(OF4OSM_NAMESPACE + OF4OSM_OSMTAGCONCEPT_PATH + OF4OSM_SEPARATOR + label), tag, parent);
    	concept.addLabel(OF4OSM_DEFAULT_LANG, label);
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
	
    public static String getLabelFromTag(IOSMTag tag, int position){
    	if(tag instanceof IOSMSimpleCategoryTag){
    		return getLabelFromIOSMSimpleCategoryTag((IOSMSimpleCategoryTag)tag);
    	} else if(tag instanceof IOSMMultipleCategoryTag){
    		return getLabelFromIOSMMultipleCategoryTag((IOSMMultipleCategoryTag)tag, position);
    	} else if(tag instanceof IOSMStatefulCategoryTag){
    		return getLabelFromIOSMStatefulCategoryTag((IOSMStatefulCategoryTag)tag);
    	} else {
    		return null;
    	}
    }
    
    public static String getLabelFromTag(IOSMTag tag){
    	return getLabelFromTag(tag, 0);
    }
    
	private static String getLabelFromIOSMSimpleCategoryTag(IOSMSimpleCategoryTag tag){
    	String label = ""; 
    	label += normalize(tag.getValue().getValue());
    	label += normalize(tag.getKey().getValue());
        return  label;
    }
    
	private static String getLabelFromIOSMMultipleCategoryTag(IOSMMultipleCategoryTag tag, int position){
    	String label = ""; 
    	label += normalize(tag.getValue().getValues()[position]);
    	label += normalize(tag.getKey().getValue());
        return  label;
    }
    
	private static String getLabelFromIOSMStatefulCategoryTag(IOSMStatefulCategoryTag tag){
    	String label = "";
    	label += normalize(tag.getKey().getState());
    	label += normalize(tag.getValue().getValue());
    	label += normalize(tag.getKey().getValue());
        return  label;
    }
	
	public static String getLabelFromKey(IOSMTagKey key){
    	if(key instanceof IOSMTagSimpleKey){
    		return getLabelFromIOSMTagSimpleKey((IOSMTagSimpleKey) key);
    	} else if(key instanceof IOSMTagComplexKey){
    		return getLabelFromIOSMTagComplexKey((IOSMTagComplexKey) key);
    	} else if(key instanceof IOSMTagLocalizedKey){
    		return getLabelFromIOSMTagLocalizedKey((IOSMTagLocalizedKey) key);
    	} else if(key instanceof IOSMTagStatefulKey){
    		return getLabelFromIOSMTagStatefulKey((IOSMTagStatefulKey) key);
    	}
    	return null;
    }
    
    private static String getLabelFromIOSMTagSimpleKey(IOSMTagSimpleKey key){
    	return normalize(key.getValue());
    }
    
    private static String getLabelFromIOSMTagComplexKey(IOSMTagComplexKey key){
    	String label = "";
    	for(String prefix : key.getPrefixes()){
    		label += normalize(prefix);
    	}
    	label += normalize(key.getValue());
    	return label;
    }
    
    private static String getLabelFromIOSMTagLocalizedKey(IOSMTagLocalizedKey key){
    	return normalize(key.getValue());
    }
    
    private static String getLabelFromIOSMTagStatefulKey(IOSMTagStatefulKey key){
    	String label = "";
    	label += normalize(key.getState());
    	label += normalize(key.getValue());
    	return label;
    }
    
}
