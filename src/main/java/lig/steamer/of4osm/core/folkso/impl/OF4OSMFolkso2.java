/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.folkso.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lig.steamer.of4osm.IOF4OSMFolkso;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;

/**
 *
 * @author amehiris
 */
public class OF4OSMFolkso2 implements IOF4OSMFolkso{
    
     private Map<Integer, Set<IOSMTag>> tags ;
     
    public OF4OSMFolkso2(){}

    @Override
    public Map<Integer, Set<IOSMTag>> getTags() {
       return tags;
    }

    @Override
    public Set<IOSMCategoryTag> getIOSMCategoryTags() {
        Set<IOSMCategoryTag> catTags = new HashSet<>();
        for(Entry<Integer, Set<IOSMTag>> entry : tags.entrySet()){
            for(IOSMTag tag : entry.getValue()){
                if(IOSMCategoryTag.class.isInstance(tag)){
                    catTags.add((IOSMCategoryTag)tag);
                }
            }
        }
        return catTags;
    }

    @Override
    public int getOccurrences(IOSMTag tag) {
        int nbOcc = 0;
        for(Entry<Integer, Set<IOSMTag>> entry : tags.entrySet()){
            for(IOSMTag currTag : entry.getValue()){
                if(tag.equals(currTag)){
                    nbOcc++;
                }
            }
        }
        return nbOcc;
    }
  
     
}
