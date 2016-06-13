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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lig.steamer.of4osm.ws.osmapi.Tag;

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
    private final String wikiURL;

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

    public Map<Tag, Integer> getTags() {

        Map<Tag, Integer> tags = new HashMap();

        List<Element> elements = this.headResult.getElements();
        for (Element element : elements) {

            Map<String, String> mapTags = element.getTags();
            
            for (Map.Entry<String, String> entry : mapTags.entrySet()) {
                Tag overPassTag = new Tag( entry.getKey(),entry.getValue());

                if (tags.get(overPassTag) == null) {
                    tags.put(overPassTag, 1);
                } else {
                    int nbOccur = tags.get(overPassTag);
                    tags.put(overPassTag, 1 + nbOccur);
                }
            }
        }

        return tags;
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
