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
public class KeyStats {

    public KeyStatsHead keyStatsHead;

    public KeyStats(String key) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/stats?key=");
        str.append(key);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());

        this.keyStatsHead = objectMapper.readValue(url, KeyStatsHead.class);

    }
}
