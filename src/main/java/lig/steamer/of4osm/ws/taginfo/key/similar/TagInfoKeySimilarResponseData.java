/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.taginfo.key.similar;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponseData;

/**
 * Find keys that are similar to a given key.
 *
 * @author amehiris
 */
public class TagInfoKeySimilarResponseData extends TagInfoResponseData {

    // Other key.
    private String other_key;
    // Number of objects that have the other key.
    private int count_all;
    // An integer measuring the similarity of the two keys, smaller is more similar
    private int similarity;

    public String getOther_key() {
        return other_key;
    }

    public int getCount_all() {
        return count_all;
    }

    public int getSimilarity() {
        return similarity;
    }

    public void setOther_key(String other_key) {
        this.other_key = other_key;
    }

    public void setCount_all(int count_all) {
        this.count_all = count_all;
    }

    public void setSimilarity(int similarity) {
        this.similarity = similarity;
    }
    
    @Override
    public String toString() {
        return "{ \"other_key\" : " + other_key +
        		", \"count_all\" : " + count_all +
        		", \"similarity\" : "+similarity+"}\n";
    }
}
