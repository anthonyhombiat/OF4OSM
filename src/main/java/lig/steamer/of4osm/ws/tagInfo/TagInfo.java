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
public class TagInfo {

    public TagsPopularHead tagsPopular() throws MalformedURLException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("https://taginfo.openstreetmap.org/api/4/tags/popular?");
        TagsPopularHead tagsPopularHead = new TagsPopularHead();
        tagsPopularHead = objectMapper.readValue(url, TagsPopularHead.class);
        return tagsPopularHead;
    }

    public TagsPopularHead tagsPopular(int page, int rp) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/tags/popular?");
        str.append("page=");
        str.append(page);
        str.append("&rp=");
        str.append(rp);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        TagsPopularHead tagsPopularHead = new TagsPopularHead();
        tagsPopularHead = objectMapper.readValue(url, TagsPopularHead.class);
        return tagsPopularHead;
    }

    public KeyCombinationsHead keyCombinations(String key) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/combinations?key=");
        str.append(key);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        KeyCombinationsHead KeyCombinationsHead = new KeyCombinationsHead();
        KeyCombinationsHead = objectMapper.readValue(url, KeyCombinationsHead.class);
        return KeyCombinationsHead;
    }

    public KeyCombinationsHead keyCombinations(String key, int page, int rp) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/combinations?key=");
        str.append(key);
        str.append("&page=");
        str.append(page);
        str.append("&rp=");
        str.append(rp);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        KeyCombinationsHead KeyCombinationsHead = new KeyCombinationsHead();
        KeyCombinationsHead = objectMapper.readValue(url, KeyCombinationsHead.class);
        return KeyCombinationsHead;
    }

    public KeySimilarHead keySimilar(String key, int page, int rp) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/similar?key=");
        str.append(key);
        str.append("&page=");
        str.append(page);
        str.append("&rp=");
        str.append(rp);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        KeySimilarHead keySimilarHead = new KeySimilarHead();
        keySimilarHead = objectMapper.readValue(url, KeySimilarHead.class);
        return keySimilarHead;
    }

    public KeySimilarHead keySimilar(String key) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/similar?key=");
        str.append(key);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        KeySimilarHead keySimilarHead = new KeySimilarHead();
        keySimilarHead = objectMapper.readValue(url, KeySimilarHead.class);
        return keySimilarHead;
    }

    public KeyStatsHead keyStats(String key) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/stats?key=");
        str.append(key);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        KeyStatsHead keyStatsHead = new KeyStatsHead();
        keyStatsHead = objectMapper.readValue(url, KeyStatsHead.class);
        return keyStatsHead;
    }

    public KeyValuesHead keyValues(String key) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/values?key=");
        str.append(key);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        KeyValuesHead keyValuesHead = new KeyValuesHead();
        keyValuesHead = objectMapper.readValue(url, KeyValuesHead.class);
        return keyValuesHead;
    }

    public KeyValuesHead keyValues(String key, int page, int rp) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/key/values?key=");
        str.append(key);
        str.append("&page=");
        str.append(page);
        str.append("&rp=");
        str.append(rp);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        KeyValuesHead keyValuesHead = new KeyValuesHead();
        keyValuesHead = objectMapper.readValue(url, KeyValuesHead.class);
        return keyValuesHead;
    }

    public TagStatsHead tagStats(String key, String value) throws MalformedURLException, IOException {

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/tag/stats?key=");
        str.append(key);
        str.append("&value=");
        str.append(value);

        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(str.toString());
        TagStatsHead tagStatsHead = new TagStatsHead();
        tagStatsHead = objectMapper.readValue(url, TagStatsHead.class);
        return tagStatsHead;
    }

}
