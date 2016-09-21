/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.util;

import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author amehiris
 */
public final class OntoLabelExtractor {
    
    public static String getLabelFromIOSMSimpleCategoryTag(IOSMSimpleCategoryTag tag){
        return WordUtils.capitalize(tag.getValue().getValue()) + WordUtils.capitalize(tag.getKey().getValue());
    }
    
    public static String getLabelFromIOSMMultipleCategoryTag(IOSMMultipleCategoryTag tag, int position){
        return  WordUtils.capitalize(tag.getValue().getValues()[position]) + WordUtils.capitalize(tag.getKey().getValue());
    }
    
    public static String getLabelFromIOSMStatefulCategoryTag(IOSMStatefulCategoryTag tag){
        return WordUtils.capitalize(tag.getValue().getValue()) + WordUtils.capitalize(tag.getKey().getValue());
    }
    
}
