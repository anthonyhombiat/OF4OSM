package lig.steamer.of4osm.folkso.tag.component.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.IOSMTagSimpleKey;

/**
 *
 */
public class OSMTagComplexKey extends OSMTagKey implements IOSMTagComplexKey {

    /**
     *
     */
    public OSMTagSimpleKey firstValue;

    /**
     *
     */
    public Set<String> values;

    
    public OSMTagComplexKey(String value, String wikiURL) {
        super(value, wikiURL);
        String[] values = value.split(":");
        this.firstValue = new OSMTagSimpleKey(values[0], wikiURL);
        this.values = new HashSet();
        this.values.addAll(Arrays.asList(values));
    }

    public Set<String> getValues() {
        return values;
    }

    public IOSMTagSimpleKey getKey() {
        return firstValue;
    }

}
