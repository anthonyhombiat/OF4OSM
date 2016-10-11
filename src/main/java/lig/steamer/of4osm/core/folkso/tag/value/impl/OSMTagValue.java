package lig.steamer.of4osm.core.folkso.tag.value.impl;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public abstract class OSMTagValue implements IOSMTagValue {

    protected Set<String> labels;

    @Override
    public Set<String> getLabels() {

        return labels;
    }

}
