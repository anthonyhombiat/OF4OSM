/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overPass;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author amehiris
 */
public class OverPass {

    private final String bBox;
    private final String typeElement;
    private final String key;
    private final String value;
    private final HeadResult headResult;
    private String wikiURL;

    public OverPass(String bBox, String typeElement, String key, String value) throws MalformedURLException, IOException {
        this.bBox = bBox;
        this.typeElement = typeElement;
        this.key = key;
        this.value = value;

        StringBuilder str = new StringBuilder();
        str.append("http://overpass-api.de/api/interpreter?[out:json];(");
        str.append(typeElement);
        str.append("[");
        str.append(key);
        str.append("=");
        str.append(value);
        str.append("]");
        str.append(bBox);
        str.append(";);out;");
        
        this.wikiURL = str.toString();  
        URL url = new URL(this.wikiURL);
        ObjectMapper objectMapper = new ObjectMapper();

        this.headResult = objectMapper.readValue(url, HeadResult.class);

    }

    public String getbBox() {
        return bBox;
    }

    public String getTypeElement() {
        return typeElement;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public HeadResult getHeadResult() {
        return headResult;
    }

    public String getWikiURL() {
        return wikiURL;
    }

}
