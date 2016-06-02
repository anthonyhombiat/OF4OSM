/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overPass;

import java.util.List;
import java.util.Map;

/**
 *
 * @author amehiris
 */
public class Element {

    private String type;
    
    private String id;
    
    private String lat;
    
    private String lon;
   
    private Map tags;
     
    private List<String> nodes;
    
     @Override
    public String toString()
    {
        return "{\"type\" : \""+type+"\",\n \"id\" :\" "+id+"\",\n \"lat\" :\" "+lat+"\",\n \"lon\" :\" "+lon+"\",\n \"nodes\" :\" "+nodes+"\",\n \"tags\" :\" "+tags+"}\n";
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public Map getTags() {
        return tags;
    }

    public void setTags(Map tags) {
        this.tags = tags;
    }
  
}
