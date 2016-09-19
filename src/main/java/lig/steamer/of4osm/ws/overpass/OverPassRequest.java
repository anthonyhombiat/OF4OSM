/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overpass;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author amehiris
 */
public class OverPassRequest {

    private final URL url;

    public OverPassRequest(String bBox, String typeElement, String key, String value) throws MalformedURLException {

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
        this.url = new URL(str.toString());
    }

    public URL getUrl() {
        return url;
    }

}
