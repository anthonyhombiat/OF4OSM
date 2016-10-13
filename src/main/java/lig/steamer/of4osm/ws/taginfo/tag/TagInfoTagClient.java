package lig.steamer.of4osm.ws.taginfo.tag;

import java.io.IOException;
import java.net.URISyntaxException;

import lig.steamer.of4osm.ws.taginfo.tag.stats.TagInfoTagStatsResponse;
import lig.steamer.of4osm.ws.taginfo.ITagInfoResponse;
import lig.steamer.of4osm.ws.taginfo.TagInfoRequest;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author amehiris
 */
public class TagInfoTagClient  {

	public final static String PATH = "tag/";
	
    public TagInfoTagClient(){}

    public ITagInfoResponse send(String action, String key, String value, int page, int rp) {

		try {
    		
	    	URIBuilder uriBuilder;
			uriBuilder = new URIBuilder(TagInfoRequest.ENDPOINT + PATH + action);
	        uriBuilder.addParameter(TagInfoRequest.PARAM_KEY, key);
	        uriBuilder.addParameter(TagInfoRequest.PARAM_VALUE, value);
	        uriBuilder.addParameter(TagInfoRequest.PARAM_PAGE, "" + page);
	        uriBuilder.addParameter(TagInfoRequest.PARAM_RP, "" + rp);
	
	        ObjectMapper objectMapper = new ObjectMapper();
	        
	        switch (action) {
		        case TagInfoTagAction.STATS:
		        	return objectMapper.readValue(
							uriBuilder.build().toURL(), 
							TagInfoTagStatsResponse.class);
			}
	        
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (URISyntaxException e) { 
			e.printStackTrace();
		}
    	
    	return null;
    	
    }

    public ITagInfoResponse send(String action, String key, String value) {
    	return send(action, key, value, TagInfoRequest.DEFAULT_PAGE, TagInfoRequest.DEFAULT_RP);
    }
    
}
