package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Objects;
import java.util.Set;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;

import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

import org.apache.commons.lang3.text.WordUtils;

/**
 *
 */
public class OSMCategoryTagConcept extends OSMTagConcept implements IOSMCategoryTagConcept {

    public IOSMCategoryTag tag;

    public OSMCategoryTagConcept(String label, IOSMCategoryTag tag, IOSMCategoryTagKeyConcept tagKeyConcept) {
        this.tag = tag;
        super.addLabel("EN", label);
        super.parents.add(tagKeyConcept);
    }

    @Override
    public IOSMCategoryTag getTag() {
        return tag;
    }

    @Override
    public Set<? extends IOSMTagConceptParent> getParents() {
        
        return super.parents;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.tag);
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
        final OSMCategoryTagConcept other = (OSMCategoryTagConcept) obj;
        if (!Objects.equals(this.tag, other.tag)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" + getDefaultLabel() + '}';
    }

}
