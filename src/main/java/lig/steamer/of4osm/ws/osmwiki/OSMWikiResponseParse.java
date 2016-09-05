package lig.steamer.of4osm.ws.osmwiki;

import java.util.List;

public class OSMWikiResponseParse {
	
	private String title;
	private int pageid;
	private List<OSMWikiResponseParseSection> sections;
	private OSMWikiResponseParseText text;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPageid() {
		return pageid;
	}
	
	public void setPageid(int pageid) {
		this.pageid = pageid;
	}
	
	public List<OSMWikiResponseParseSection> getSections() {
		return sections;
	}
	
	public void setSections(List<OSMWikiResponseParseSection> sections) {
		this.sections = sections;
	}

	public OSMWikiResponseParseText getText() {
		return text;
	}

	public void setText(OSMWikiResponseParseText text) {
		this.text = text;
	}

}
