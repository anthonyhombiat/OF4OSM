package lig.steamer.of4osm.ws.osmwiki;

public class OSMMediaWikiAPIRequest extends MediaWikiAPIRequest{

	public OSMMediaWikiAPIRequest(){
		super("parse", "Map_Features", "text", "json");
	}
	
}
