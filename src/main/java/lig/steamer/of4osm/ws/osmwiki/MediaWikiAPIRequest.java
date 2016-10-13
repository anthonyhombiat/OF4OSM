package lig.steamer.of4osm.ws.osmwiki;

public class MediaWikiAPIRequest {
	
	private String act; 
	private String page; 
	private String prop; 
	private String fmt; 

	public MediaWikiAPIRequest(String action, String page, String prop, String fmt){
		this.act = action;
		this.page = page;
		this.prop = prop;
		this.fmt = fmt;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

	public String getFmt() {
		return fmt;
	}

	public void setFmt(String fmt) {
		this.fmt = fmt;
	}	
	
}
