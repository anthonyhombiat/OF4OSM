/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overPass;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author amehiris
 */
public class OverPassClient {

    public OverPassClient() {
    }
    
    public OverPassResponse send(OverPassRequest req) throws IOException{
        
        ObjectMapper objectMapper = new ObjectMapper();
        OverPassResponse overPassResponse = objectMapper.readValue(req.getUrl(), OverPassResponse.class);
        
        return overPassResponse;
    }
}
