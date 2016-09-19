/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm;

import java.util.Map;
import java.util.Set;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;

/**
 *
 * @author amehiris
 */
public interface IOF4OSMFolkso {
    
    public Map<Integer,Set<IOSMTag>> getTags();
    
    public Set<IOSMCategoryTag> getIOSMCategoryTags();
    
    public int getOccurrences(IOSMTag tag);
    
}
