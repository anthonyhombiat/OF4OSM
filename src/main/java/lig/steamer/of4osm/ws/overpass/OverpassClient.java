/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overpass;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author amehiris
 */
public class OverpassClient {

	private static final Logger LOGGER = Logger.getLogger(OverpassClient.class.getName());
	
    public OverpassClient() {
    }
    
    public OverpassResponse send(OverpassRequest req) {
        
    	LOGGER.log(Level.INFO, "Sending request to the Overpass API...");
    	
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			
			LOGGER.log(Level.INFO, "Sending request to the OSM MediaWiki API done.");
			
	        return objectMapper.readValue(req.getUrl(), OverpassResponse.class);
	        
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
