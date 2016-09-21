/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.taginfo.key;

import java.io.IOException;
import java.net.URISyntaxException;

import lig.steamer.of4osm.ws.taginfo.key.similar.TagInfoKeySimilarResponse;
import lig.steamer.of4osm.ws.taginfo.key.stats.TagInfoKeyStatsResponse;
import lig.steamer.of4osm.ws.taginfo.key.values.TagInfoKeyValuesResponse;
import lig.steamer.of4osm.ws.taginfo.ITagInfoResponse;
import lig.steamer.of4osm.ws.taginfo.TagInfoRequest;
import lig.steamer.of4osm.ws.taginfo.key.combinations.TagInfoKeyCombinationsResponse;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author amehiris
 */
public class TagInfoKeyClient {

	public final static String PATH = "key/";
	
    public TagInfoKeyClient(){}

    public ITagInfoResponse send(String action, String key, int page, int rp) {

		try {
    		
	    	URIBuilder uriBuilder;
			uriBuilder = new URIBuilder(TagInfoRequest.ENDPOINT + PATH + action);
	        uriBuilder.addParameter(TagInfoRequest.PARAM_KEY, key);
	        uriBuilder.addParameter(TagInfoRequest.PARAM_PAGE, "" + page);
	        uriBuilder.addParameter(TagInfoRequest.PARAM_RP, "" + rp);
	
	        ObjectMapper objectMapper = new ObjectMapper();
	        
	        switch (action) {
		        case TagInfoKeyAction.VALUES:
		        	return objectMapper.readValue(
							uriBuilder.build().toURL(), 
							TagInfoKeyValuesResponse.class);
		        case TagInfoKeyAction.SIMILAR:
		        	return objectMapper.readValue(
							uriBuilder.build().toURL(), 
							TagInfoKeySimilarResponse.class);
		        case TagInfoKeyAction.STATS:
		        	return objectMapper.readValue(
							uriBuilder.build().toURL(), 
							TagInfoKeyStatsResponse.class);
				case TagInfoKeyAction.COMBINATIONS:
					return objectMapper.readValue(
							uriBuilder.build().toURL(), 
							TagInfoKeyCombinationsResponse.class);
			}
	        
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (URISyntaxException e) { 
			e.printStackTrace();
		}
    	
    	return null;
    	
    }

    public ITagInfoResponse send(String action, String key) {
    	return send(action, key, TagInfoRequest.DEFAULT_PAGE, TagInfoRequest.DEFAULT_RP);
    }
    
}
