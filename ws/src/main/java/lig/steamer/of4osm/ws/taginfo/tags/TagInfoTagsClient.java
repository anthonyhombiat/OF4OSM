package lig.steamer.of4osm.ws.taginfo.tags;

import java.io.IOException;
import java.net.URISyntaxException;

import lig.steamer.of4osm.ws.taginfo.tags.popular.TagInfoTagsPopularResponse;
import lig.steamer.of4osm.ws.taginfo.ITagInfoResponse;
import lig.steamer.of4osm.ws.taginfo.TagInfoRequest;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author amehiris
 */
public class TagInfoTagsClient  {

	public final static String PATH = "tags/";
	
    public TagInfoTagsClient(){}

    public ITagInfoResponse send(String action, int page, int rp) {

		try {
    		
	    	URIBuilder uriBuilder;
			uriBuilder = new URIBuilder(TagInfoRequest.ENDPOINT + PATH + action);
	        uriBuilder.addParameter(TagInfoRequest.PARAM_PAGE, "" + page);
	        uriBuilder.addParameter(TagInfoRequest.PARAM_RP, "" + rp);
	
	        ObjectMapper objectMapper = new ObjectMapper();
	        
	        switch (action) {
		        case TagInfoTagsAction.POPULAR:
		        	return objectMapper.readValue(
							uriBuilder.build().toURL(), 
							TagInfoTagsPopularResponse.class);
			}
	        
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (URISyntaxException e) { 
			e.printStackTrace();
		}
    	
    	return null;
    	
    }
    
    public ITagInfoResponse send(String action){
    	return send(action, TagInfoRequest.DEFAULT_PAGE, TagInfoRequest.DEFAULT_RP);
    }
    
}
