package lig.steamer.of4osm.ws.xapi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lig.steamer.of4osm.ws.osmapi.OSMAPIRequest;
import lig.steamer.of4osm.ws.osmapi.OSMAPIResponse;

/**
 *
 * @author amehiris
 */
public class OverpassXAPIClient {

	private static final Logger LOGGER = Logger.getLogger(OverpassXAPIClient.class.getName());
	
	public final static String ENDPOINT = "http://www.overpass-api.de/api/xapi?";
//	public final static String ENDPOINT = "http://overpass.osm.rambler.ru/cgi/xapi?";
	
	public final static String BBOX = "bbox";
	
    public OverpassXAPIClient() {
    }
    
    public OSMAPIResponse send(OSMAPIRequest req) {
        
    	LOGGER.log(Level.INFO, "Sending request to the Overpass XAPI...");

    	try {
        	
	    	StringBuilder str = new StringBuilder(ENDPOINT);
	        str.append("*[");
	        str.append(BBOX);
	        str.append("=");
	        str.append(req.getLonMin());
	        str.append(",");
	        str.append(req.getLatMin());
	        str.append(",");
	        str.append(req.getLonMax());
	        str.append(",");
	        str.append(req.getLatMax());
	        str.append("]");
       
			final URL url = new URL(str.toString());
			
			LOGGER.log(Level.INFO, "URL: " + url);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(OSMAPIResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            OSMAPIResponse osmapiResponse = (OSMAPIResponse) jaxbUnmarshaller.unmarshal(url);
			
			LOGGER.log(Level.INFO, "Sending request to the Overpass XAPI done.");
			
	        return osmapiResponse;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
        
        return null;
    }
}
