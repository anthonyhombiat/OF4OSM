/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.tagInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author amehiris
 */
public class TagsPopularWsClient {

    private TagsPopularHead tagsPopularHead;

    public TagsPopularWsClient() throws MalformedURLException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("https://taginfo.openstreetmap.org/api/4/tags/popular?");
        this.tagsPopularHead = objectMapper.readValue(url, TagsPopularHead.class);

    }

    public TagsPopularWsClient(int page, int rp) throws MalformedURLException, IOException {
        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/tags/popular?");
        str.append("page=");
        str.append(page);
        str.append("&rp=");
        str.append(rp);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        this.tagsPopularHead = objectMapper.readValue(url, TagsPopularHead.class);
    }

    public TagsPopularHead getTagsPopularHead() {
        return tagsPopularHead;
    }
    
    
}
