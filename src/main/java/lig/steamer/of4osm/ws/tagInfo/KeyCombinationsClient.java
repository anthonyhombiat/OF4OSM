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
public class KeyCombinationsClient {

	public final static String ENDPOINT = TagInfoAPI.ENDPOINT + "key/combinations";
	
    public KeyCombinationsClient(){}

    public KeyCombinationsResponse send(String key, int page, int rp) {

		try {
    		
	    	URIBuilder uriBuilder;
			uriBuilder = new URIBuilder(ENDPOINT);
	        uriBuilder.setParameter(TagInfoAPI.PARAM_KEY, key);
	        uriBuilder.setParameter(TagInfoAPI.PARAM_PAGE, "" + page);
	        uriBuilder.setParameter(TagInfoAPI.PARAM_RP, "" + rp);
	
	        ObjectMapper objectMapper = new ObjectMapper();

			return objectMapper.readValue(
					uriBuilder.build().toURL(), 
					KeyCombinationsResponse.class);
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (URISyntaxException e) { 
			e.printStackTrace();
		}
    	
    	return null;
    	
    }

    public KeyCombinationsResponse send(String key) {
    	return send(key, TagInfoAPI.DEFAULT_PAGE, TagInfoAPI.DEFAULT_RP);
    }
    
}
