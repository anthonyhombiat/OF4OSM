/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.net.MalformedURLException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author amehiris
 */
public class OSMAPIClient {

    public OSMAPIClient() {
    }

    public OSMAPIResponse send(OSMAPIRequest req) throws MalformedURLException, Exception {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(OSMAPIResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            OSMAPIResponse osmapiResponse = (OSMAPIResponse) jaxbUnmarshaller.unmarshal(req.getUrl());
            return osmapiResponse;
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

}
