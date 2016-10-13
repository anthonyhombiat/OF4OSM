package lig.steamer.of4osm.ws.overpass;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author amehiris
 */
public class OverpassAPIResponse {

    private String version;
    private String generator;
    private OverpassAPIOsm3s osm3s;
    private List<OverpassAPIElement> elements;

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
    public OverpassAPIOsm3s getOsm3s() {
        return osm3s;
    }

    public void setOsm3s(OverpassAPIOsm3s osm3s) {
        this.osm3s = osm3s;
    }

    @JsonProperty("elements")
    public List<OverpassAPIElement> getElements() {
        return elements;
    }

    public void setElements(List<OverpassAPIElement> elements) {
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
