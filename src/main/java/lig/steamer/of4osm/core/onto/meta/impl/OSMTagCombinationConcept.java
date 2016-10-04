package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;

/**
 *
 */
public class OSMTagCombinationConcept extends OSMTagCombinationConceptParent implements IOSMTagCombinationConcept {

    private Set<IOSMTagCombinationConceptParent> parents;

    public OSMTagCombinationConcept() {
        this.parents = new HashSet<>();
    }


    @Override
    public Set<? extends IOSMTagCombinationConceptParent> getParents() {
        return parents;
    }

    public void addParent(IOSMTagCombinationConceptParent parent) {
        this.parents.add(parent);
    }

    @Override
    public String toString() {
        return "parents=" + parents ;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.parents);
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
        final OSMTagCombinationConcept other = (OSMTagCombinationConcept) obj;
        if (!Objects.equals(this.parents, other.parents)) {
            return false;
        }
        return true;
    }

    
    
}
