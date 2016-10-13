package lig.steamer.of4osm.core.folkso.tag.key.impl;

import java.util.ArrayList;
import java.util.List;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class OSMTagComplexKey extends OSMTagKey implements IOSMTagComplexKey {

    private List<String> prefixes;

    public OSMTagComplexKey(String value, String wikiURL) {
        super(value, wikiURL);
        String[] values = value.split(":");
        this.value = values[0];
        prefixes = new ArrayList<>();
        for(int i = 1 ; i < values.length ; i++){
        	prefixes.add(values[i]);
        }
    }

    @Override
    public List<String> getPrefixes() {
        return prefixes;
    }

    @Override
    public String toString(){
    	String s = value;
    	for(String prefixe : prefixes){
    		s += ":" + prefixe;
    	}
    	return s;
    }
    
}
