/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Map;
import java.util.Set;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;

/**
 *
 * @author amehiris
 */
public class OSMCategoryTagKeyConcept extends Concept implements IOSMCategoryTagKeyConcept{

    public Set<IHighLevelConcept> parents;
    public IOSMTagKey key;
    
    @Override
    public Set<IHighLevelConcept> getParents() {
        return parents;
    }

    @Override
    public IOSMTagKey getKey() {
        return key;
    }
    
}
