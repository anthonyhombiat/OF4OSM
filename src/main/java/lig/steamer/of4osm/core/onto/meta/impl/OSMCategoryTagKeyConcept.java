/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Objects;
import java.util.Set;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author amehiris
 */
public class OSMCategoryTagKeyConcept extends OSMTagConceptParent implements IOSMCategoryTagKeyConcept {

    public Set<IHighLevelConcept> parents;
    public IOSMTagKey key;

    public OSMCategoryTagKeyConcept(String label, IOSMTagKey key) {
        this.key = key;
        super.addLabel("EN", label);
    }

    @Override
    public Set<IHighLevelConcept> getParents() {
        return parents;
    }

    @Override
    public IOSMTagKey getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OSMCategoryTagKeyConcept other = (OSMCategoryTagKeyConcept) obj;
        if (!Objects.equals(this.parents, other.parents)) {
            return false;
        }
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" + getDefaultLabel() + '}';
    }
    
    

}
