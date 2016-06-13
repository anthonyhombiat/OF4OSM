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
public class TagStats {

    private TagStatsHead tagStatsHead;

    public TagStats(String key, String value) throws MalformedURLException, IOException {
        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/tag/stats?key=");
        str.append(key);
        str.append("&value=");
        str.append(value);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        this.tagStatsHead = objectMapper.readValue(url, TagStatsHead.class);
    }

}
