package lig.steamer.of4osm.util;

import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;

import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author amehiris
 */
public final class OF4OSMConceptLabelizer {
	
	public static String getIOSMTagCombinationConceptLabel(IOSMTagCombinationConceptParent[] parents){
		String label = "";
		for(IOSMTagCombinationConceptParent parent : parents){
			label += parent.getDefaultLabel();
		}
		return label;
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
    
	public static String normalize(String s){
		String res = WordUtils.capitalize(s);
		res = WordUtils.capitalize(res, '_');
		res = res.replace(" ", "");
		res = res.replace("_", "");
		return res;
	}
    
}
