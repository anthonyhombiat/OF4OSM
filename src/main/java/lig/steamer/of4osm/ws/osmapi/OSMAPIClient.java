package lig.steamer.of4osm.ws.osmapi;

import java.net.MalformedURLException;
import java.net.URL;
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
	
	public final static String ENDPOINT = "http://api.openstreetmap.org/api/0.6/map?";
	public final static String BBOX = "bbox";
	
	public OSMAPIClient() {
	}

    public OSMAPIResponse send(OSMAPIRequest req) {
    	
    	LOGGER.log(Level.INFO, "Sending request to the OSM API...");
    	
    	try {
        	
	    	StringBuilder str = new StringBuilder(ENDPOINT);
	        
	    	str.append(BBOX);
	    	str.append("=");
	        str.append(req.getLonMin());
	        str.append(",");
	        str.append(req.getLatMin());
	        str.append(",");
	        str.append(req.getLonMax());
	        str.append(",");
	        str.append(req.getLatMax());
	        
	        final URL url = new URL(str.toString());
	        
	        LOGGER.log(Level.INFO, "URL: " + url);
        
	        JAXBContext jaxbContext = JAXBContext.newInstance(OSMAPIResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            OSMAPIResponse osmapiResponse = (OSMAPIResponse) jaxbUnmarshaller.unmarshal(url);
            
            LOGGER.log(Level.INFO, "Sending request to the OSM API done.");
            
            return osmapiResponse;
	        
    	} catch (MalformedURLException e) {
    		LOGGER.log(Level.INFO, "An error occured while sending request to the OSM API:" + e.getMessage());
    		e.printStackTrace();
    	} catch (JAXBException e) {
    		LOGGER.log(Level.INFO, "An error occured while sending request to the OSM API:" + e.getMessage());
            e.printStackTrace();
        }
    	
        return null;
    }

}
