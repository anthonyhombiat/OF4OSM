/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.util;

import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;

import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author amehiris
 */
public final class FolksoLabelExtractor {
    
    public static String getLabelFromIOSMSimpleCategoryTag(IOSMSimpleCategoryTag tag){
    	String label = ""; 
    	label += WordUtils.capitalize(tag.getValue().getValue().replace(' ', '_'));
    	label += WordUtils.capitalize(tag.getKey().getValue().replace(' ', '_'));
        return  label;
    }
    
    public static String getLabelFromIOSMMultipleCategoryTag(IOSMMultipleCategoryTag tag, int position){
    	String label = ""; 
    	label += WordUtils.capitalize(tag.getValue().getValues()[position].replace(' ', '_'));
    	label += WordUtils.capitalize(tag.getKey().getValue().replace(' ', '_'));
        return  label;
    }
    
    public static String getLabelFromIOSMStatefulCategoryTag(IOSMStatefulCategoryTag tag){
    	String label = ""; 
    	label += WordUtils.capitalize(tag.getValue().getValue());
    	label += WordUtils.capitalize(tag.getKey().getValue());
        return  label;
    }
    
}
