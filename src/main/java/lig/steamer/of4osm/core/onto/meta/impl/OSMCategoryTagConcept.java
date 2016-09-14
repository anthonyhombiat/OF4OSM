package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.Objects;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

/**
 *
 */
public class OSMCategoryTagConcept extends OSMTagConcept implements IOSMCategoryTagConcept {

    public IOSMSimpleCategoryTag tag;

    public OSMCategoryTagConcept(OSMSimpleCategoryTag tag) {
        this.tag = tag;
        //super.labels.add(tag.getValue().getValue()+tag.getKey().getValue());
        // super.parents.add(tagKeyConcept);
    }

    @Override
    public IOSMSimpleCategoryTag getTag() {
        return tag;
    }

    @Override
    public Set<? extends IOSMTagConceptParent> getParents() {
        // TODO Auto-generated method stub
        return null;
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
        return "OSMCategoryTagConcept{" + "tag=" + tag + '}';
    }

}
