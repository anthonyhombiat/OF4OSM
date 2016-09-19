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
public class TagInfoClient {

    public TagsPopularResponse tagsPopular() throws MalformedURLException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("https://taginfo.openstreetmap.org/api/4/tags/popular");
        return objectMapper.readValue(url, TagsPopularResponse.class);
    }

    public TagsPopularResponse tagsPopular(int page, int rp) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/tags/popular?");
        str.append("page=");
        str.append(page);
        str.append("&rp=");
        str.append(rp);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        return objectMapper.readValue(url, TagsPopularResponse.class);
    }

    public KeyCombinationsResponse keyCombinations(String key) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/combinations?key=");
        str.append(key);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        return objectMapper.readValue(url, KeyCombinationsResponse.class);
    }

    public KeyCombinationsResponse keyCombinations(String key, int page, int rp) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/combinations?key=");
        str.append(key);
        str.append("&page=");
        str.append(page);
        str.append("&rp=");
        str.append(rp);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        return objectMapper.readValue(url, KeyCombinationsResponse.class);
    }

    public KeySimilarResponse keySimilar(String key, int page, int rp) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/similar?key=");
        str.append(key);
        str.append("&page=");
        str.append(page);
        str.append("&rp=");
        str.append(rp);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        return objectMapper.readValue(url, KeySimilarResponse.class);
    }

    public KeySimilarResponse keySimilar(String key) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/similar?key=");
        str.append(key);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        return objectMapper.readValue(url, KeySimilarResponse.class);
    }

    public KeyStatsResponse keyStats(String key) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/stats?key=");
        str.append(key);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        return objectMapper.readValue(url, KeyStatsResponse.class);
    }

    public KeyValuesResponse keyValues(String key) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/values?key=");
        str.append(key);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        return objectMapper.readValue(url, KeyValuesResponse.class);
    }

    public KeyValuesResponse keyValues(String key, int page, int rp) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/values?key=");
        str.append(key);
        str.append("&page=");
        str.append(page);
        str.append("&rp=");
        str.append(rp);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        return objectMapper.readValue(url, KeyValuesResponse.class);
    }

    public TagStatsResponse tagStats(String key, String value) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/tag/stats?key=");
        str.append(key);
        str.append("&value=");
        str.append(value);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        return objectMapper.readValue(url, TagStatsResponse.class);
    }

}
