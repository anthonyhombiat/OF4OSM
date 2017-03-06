package lig.steamer.of4osm.ws.osmwiki;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaWikiAPIResponseParseText {

	private String all;

	@JsonProperty("*")
	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}
	
}
