package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

/**
 *
 */
public interface IOSMTagCombinationConcept extends IOSMTagCombinationConceptParent {

    @Override
    public Set<? extends IOSMTagCombinationConceptParent> getParents();

}
