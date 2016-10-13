package lig.steamer.of4osm.ws.overpass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author amehiris
 */
public class OverpassAPIClient {

	private static final Logger LOGGER = Logger.getLogger(OverpassAPIClient.class.getName());
	
	public final static String ENDPOINT = "http://overpass-api.de/api/interpreter?";
	
    public OverpassAPIClient() {
    }
    
    public OverpassAPIResponse send(OverpassAPIRequest req) {
        
    	LOGGER.log(Level.INFO, "Sending request to the Overpass API...");

    	try {
        	
	    	StringBuilder str = new StringBuilder(ENDPOINT);
	        str.append("[out:json];(");
	        str.append(req.getTypeElement());
	        str.append("[");
	        str.append(req.getKey());
	        str.append("=");
	        str.append(req.getValue());
	        str.append("](");
	        str.append(req.getBbox());
	        str.append("););out;");
       
			final URL url = new URL(str.toString());
			
			LOGGER.log(Level.INFO, "URL: " + url);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			LOGGER.log(Level.INFO, "Sending request to the Overpass API done.");
			
	        return objectMapper.readValue(url, OverpassAPIResponse.class);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return null;
    }
}
