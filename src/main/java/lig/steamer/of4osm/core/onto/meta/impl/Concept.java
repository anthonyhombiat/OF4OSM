package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IConcept;

/**
 *
 */
public abstract class Concept implements IConcept {

    public Map<String, String> labels;

    public Concept() {
        this.labels = new HashMap<>();
    }

    @Override
    public Map<String, String> getLabels() {
        return labels;
    }

    public void addLabel(String lang, String label) {
        labels.put(lang, label);
    }

    @Override
    public abstract Set<? extends IConcept> getParents();

    public String getDefaultLabel() {
        return labels.get("EN");
    }

}
