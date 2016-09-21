/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.taginfo.tags.popular;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponseData;

/**
 * Get list of most often used tags.
 *
 * @author amehiris
 */
public class TagInfoTagsPopularResponseData extends TagInfoResponseData {

    // Key
    private String key;
    // Value
    private String value;
    // In there a page in the wiki for this tag?
    private boolean in_wiki;
    // Number of objects in the OSM database with this tag.
    private int count_all;
    // Number of objects in relation to all objects.
    private float count_all_fraction;
    // Number of nodes in the OSM database with this tag
    private int count_nodes;
    // Number of nodes in relation to all tagged nodes.
    private float count_nodes_fraction;
    // Number of ways in the OSM database with this tag.
    private int count_ways;
    // Number of ways in relation to all ways.
    private float count_ways_fraction;
    // Number of relations in the OSM database with this tag.
    private int count_relations;
    // Number of relations in relation to all relations.
    private float count_relations_fraction;
    
    private int projects;
    
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public boolean isIn_wiki() {
        return in_wiki;
    }

    public int getCount_all() {
        return count_all;
    }

    public float getCount_all_fraction() {
        return count_all_fraction;
    }

    public int getCount_nodes() {
        return count_nodes;
    }

    public float getCount_nodes_fraction() {
        return count_nodes_fraction;
    }

    public int getCount_ways() {
        return count_ways;
    }

    public float getCount_ways_fraction() {
        return count_ways_fraction;
    }

    public int getCount_relations() {
        return count_relations;
    }

    public float getCount_relations_fraction() {
        return count_relations_fraction;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIn_wiki(boolean in_wiki) {
        this.in_wiki = in_wiki;
    }

    public void setCount_all(int count_all) {
        this.count_all = count_all;
    }

    public void setCount_all_fraction(float count_all_fraction) {
        this.count_all_fraction = count_all_fraction;
    }

    public void setCount_nodes(int count_nodes) {
        this.count_nodes = count_nodes;
    }

    public void setCount_nodes_fraction(float count_nodes_fraction) {
        this.count_nodes_fraction = count_nodes_fraction;
    }

    public void setCount_ways(int count_ways) {
        this.count_ways = count_ways;
    }

    public void setCount_ways_fraction(float count_ways_fraction) {
        this.count_ways_fraction = count_ways_fraction;
    }

    public void setCount_relations(int count_relations) {
        this.count_relations = count_relations;
    }

    public void setCount_relations_fraction(float count_relations_fraction) {
        this.count_relations_fraction = count_relations_fraction;
    }

    public int getProjects() {
        return projects;
    }

    public void setProjects(int projects) {
        this.projects = projects;
    }
    
    @Override
    public String toString() {
        return "{ \"key\" : " + key + 
        		", \"value\" : " + value + 
        		", \"in_wiki\" : " + in_wiki + 
                ", \"count_all\" : " + count_all + 
                ", \"count_all_fraction\" : " + count_all_fraction +
                ", \"count_nodes\" : " + count_nodes + 
                ", \"count_nodes_fraction\" : " + count_nodes_fraction +
                ", \"count_ways\" : " + count_ways + 
                ", \"count_ways_fraction\" : " + count_ways_fraction +
                ", \"count_relations\" : " + count_relations + 
                ", \"count_relations_fraction\" : " + count_relations_fraction +"}\n";
    }

}
