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
public class KeySimilar {

    private KeySimilarHead keySimilarHead;

    public KeySimilar(String key, int page, int rp) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/similar?key=");
        str.append(key);
        str.append("&page=");
        str.append(page);
        str.append("&rp=");
        str.append(rp);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());

        this.keySimilarHead = objectMapper.readValue(url, KeySimilarHead.class);

    }

    public KeySimilar(String key) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/similar?key=");
        str.append(key);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());

        this.keySimilarHead = objectMapper.readValue(url, KeySimilarHead.class);

    }

}
