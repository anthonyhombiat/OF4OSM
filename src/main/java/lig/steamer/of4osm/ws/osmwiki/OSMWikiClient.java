package lig.steamer.of4osm.ws.osmwiki;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OSMWikiClient {
	
	private static final Logger LOGGER = Logger.getLogger(OSMWikiClient.class.getName());
	
	public final static String ENDPOINT = "https://wiki.openstreetmap.org/w/api.php?";
	
	public final static String ACT = "action";
	public final static String PAGE = "page";
	public final static String PROP = "prop";
	public final static String FMT = "format";
	
	public OSMWikiClient(){}
	
	public OSMWikiResponse send(OSMWikiRequest req) {
		
		LOGGER.log(Level.INFO, "Sending request to the OSM MediaWiki API...");
		
		URIBuilder uriBuilder;
		
		try {
			uriBuilder = new URIBuilder(ENDPOINT);
			uriBuilder.setParameter(ACT, req.getAct());
			uriBuilder.setParameter(PAGE, req.getPage());
			uriBuilder.setParameter(PROP, req.getProp());
			uriBuilder.setParameter(FMT, req.getFmt());
			
			URL osmWikiURL = uriBuilder.build().toURL();
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			LOGGER.log(Level.INFO, "Sending request to the OSM MediaWiki API done.");
			
			return objectMapper.readValue(osmWikiURL, OSMWikiResponse.class);
			
		} catch (URISyntaxException e) {
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
