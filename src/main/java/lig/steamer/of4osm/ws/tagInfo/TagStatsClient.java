/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.tagInfo;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author amehiris
 */
public class TagStatsClient {

	public final static String ENDPOINT = TagInfoAPI.ENDPOINT + "tag/stats";

    public TagStatsResponse send(String key, String value) {
try {
    		
	    	URIBuilder uriBuilder;
			uriBuilder = new URIBuilder(ENDPOINT);
	        uriBuilder.setParameter(TagInfoAPI.PARAM_KEY, key);
	        uriBuilder.setParameter(TagInfoAPI.PARAM_VALUE, value);
	
	        ObjectMapper objectMapper = new ObjectMapper();

			return objectMapper.readValue(
					uriBuilder.build().toURL(), 
					TagStatsResponse.class);
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (URISyntaxException e) { 
			e.printStackTrace();
		}
    	
    	return null;
    }

}
