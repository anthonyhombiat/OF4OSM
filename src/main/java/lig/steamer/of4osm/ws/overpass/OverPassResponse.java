/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overpass;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author amehiris
 */
public class OverPassResponse {

    private String version;

    private String generator;

    private OverPassOsm3s osm3s;

    private List<OverPassElement> elements;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    @JsonProperty("osm3s")
    public OverPassOsm3s getOsm3s() {
        return osm3s;
    }

    public void setOsm3s(OverPassOsm3s osm3s) {
        this.osm3s = osm3s;
    }

    @JsonProperty("elements")
    public List<OverPassElement> getElements() {
        return elements;
    }

    public void setElements(List<OverPassElement> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "{\"version\" : \"" + version + 
        		"\",\n \"generator\" :\" " + generator + 
        		"\", \"osm3s\" : " + osm3s + 
        		",\n \"elements\" : \n" + elements + "}\n";
    }
    
}
