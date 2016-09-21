/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overpass;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 *
 * @author amehiris
 */
public class OverPassClient {

    public OverPassClient() {
    }
    
    public OverPassResponse send(OverPassRequest req) {
        
		try {
			ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.readValue(req.getUrl(), OverPassResponse.class);
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
