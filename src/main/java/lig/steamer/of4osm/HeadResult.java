/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm;

import java.util.List;

/**
 *
 * @author amehiris
 */
public class HeadResult {
    
    private String version;
    
    private String generator;

    private Osm3s osm3s;

    private List<Elements> elements;
    
    
    @Override
    public String toString()
    {
        return "{\"version\" : \""+version+"\",\n \"generator\" :\" "+generator+"\", \"osm3s\" : "+osm3s+",\n \"elements\" : \n"+elements+"}\n";
    }

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

    public Osm3s getOsm3s() {
        return osm3s;
    }

    public void setOsm3s(Osm3s osm3s) {
        this.osm3s = osm3s;
    }

    public List<Elements> getElements() {
        return elements;
    }

    public void setElements(List<Elements> elements) {
        this.elements = elements;
    }

    
}
