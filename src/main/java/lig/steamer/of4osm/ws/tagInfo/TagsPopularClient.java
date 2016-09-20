package lig.steamer.of4osm.ws.tagInfo;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TagsPopularClient {

	public final static String ENDPOINT = TagInfoAPI.ENDPOINT + "tags/popular";
	
    public TagsPopularClient(){}

    public TagsPopularResponse send(int page, int rp) {

		try {
    		
	    	URIBuilder uriBuilder;
			uriBuilder = new URIBuilder(ENDPOINT);
	        uriBuilder.setParameter(TagInfoAPI.PARAM_PAGE, "" + page);
	        uriBuilder.setParameter(TagInfoAPI.PARAM_RP, "" + rp);
	
	        ObjectMapper objectMapper = new ObjectMapper();

			return objectMapper.readValue(
					uriBuilder.build().toURL(), 
					TagsPopularResponse.class);
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (URISyntaxException e) { 
			e.printStackTrace();
		}
    	
    	return null;
    	
    }

    public TagsPopularResponse send() {
    	return send(TagInfoAPI.DEFAULT_PAGE, TagInfoAPI.DEFAULT_RP);
    }
	
}
