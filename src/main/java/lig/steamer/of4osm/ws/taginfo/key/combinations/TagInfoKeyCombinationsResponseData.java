/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.taginfo.key.combinations;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponseData;

/**
 *Find keys that are used together with a given key.
 * @author amehiris
 */
public class TagInfoKeyCombinationsResponseData extends TagInfoResponseData {

    // Other key
    private String other_key;

    // Number of objects that have both keys.
    private int together_count;

    // Fraction of objects with this key that also have the other key.
    private float to_fraction;

    // Fraction of objects with other key that also have this key.
    private float from_fraction;

    public String getOther_key() {
        return other_key;
    }

    public int getTogether_count() {
        return together_count;
    }

    public float getTo_fraction() {
        return to_fraction;
    }

    public float getFrom_fraction() {
        return from_fraction;
    }

    public void setOther_key(String other_key) {
        this.other_key = other_key;
    }

    public void setTogether_count(int together_count) {
        this.together_count = together_count;
    }

    public void setTo_fraction(float to_fraction) {
        this.to_fraction = to_fraction;
    }

    public void setFrom_fraction(float from_fraction) {
        this.from_fraction = from_fraction;
    }
    
     @Override
    public String toString() {
        return "{ \"other_key\" : " + other_key +
        		", \"together_count\" : " + together_count +
        		", \"to_fraction\" : " + to_fraction + 
        		", \"from_fraction\" : " + from_fraction + "}\n";
    }
}
