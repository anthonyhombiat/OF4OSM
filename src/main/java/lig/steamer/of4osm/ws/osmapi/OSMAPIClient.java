/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author amehiris
 */
public class OSMAPIClient {

	private static final Logger LOGGER = Logger.getLogger(OSMAPIClient.class.getName());
	
	public OSMAPIClient() {
	}

    public OSMAPIResponse send(OSMAPIRequest req) {
    	
    	LOGGER.log(Level.INFO, "Sending request to the OSM API...");
    	
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(OSMAPIResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            OSMAPIResponse osmapiResponse = (OSMAPIResponse) jaxbUnmarshaller.unmarshal(req.getUrl());
            
            LOGGER.log(Level.INFO, "Sending request to the OSM API done.");
            
            return osmapiResponse;
        } catch (JAXBException e) {
        	LOGGER.log(Level.INFO, "An error occured while sending request to the OSM API:" + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

}
