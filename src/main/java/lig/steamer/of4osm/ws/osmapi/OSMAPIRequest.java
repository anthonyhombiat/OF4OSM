/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author amehiris
 */
public class OSMAPIRequest {

    private URL url;
    
    public OSMAPIRequest(String lonMin , String latMin , String lonMax , String latMax) {
    
    	try {
    	
	    	StringBuilder str = new StringBuilder();
	        
	        str.append("http://api.openstreetmap.org/api/0.6/map?bbox=");
	        str.append(lonMin);
	        str.append(",");
	        str.append(latMin);
	        str.append(",");
	        str.append(lonMax);
	        str.append(",");
	        str.append(latMax);
	        
	        this.url = new URL(str.toString());
        
    	} catch (MalformedURLException e) {
    		e.printStackTrace();
    	}
       
    }
    
    public URL getUrl() {
        return url;
    }
    
}
