package lig.steamer.of4osm.core.folkso.tag.component.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagComplexKey;

/**
 *
 */
public class OSMTagComplexKey extends OSMTagKey implements IOSMTagComplexKey {

    public Set<String> prefixes;

    public OSMTagComplexKey(String value, String wikiURL) {
        super(value, wikiURL);
        String[] values = value.split(":");
        this.value = values[0];
        this.prefixes = new HashSet();
        this.prefixes.addAll(Arrays.asList(values));
    }

    public Set<String> getPrefixes() {
        return prefixes;
    }

}
