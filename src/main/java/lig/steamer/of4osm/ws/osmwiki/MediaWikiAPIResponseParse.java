package lig.steamer.of4osm.ws.osmwiki;

import java.util.List;

public class MediaWikiAPIResponseParse {
	
	private String title;
	private int pageid;
	private List<MediaWikiAPIResponseParseSection> sections;
	private MediaWikiAPIResponseParseText text;
	
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
	
	public List<MediaWikiAPIResponseParseSection> getSections() {
		return sections;
	}
	
	public void setSections(List<MediaWikiAPIResponseParseSection> sections) {
		this.sections = sections;
	}

	public MediaWikiAPIResponseParseText getText() {
		return text;
	}

	public void setText(MediaWikiAPIResponseParseText text) {
		this.text = text;
	}

}
