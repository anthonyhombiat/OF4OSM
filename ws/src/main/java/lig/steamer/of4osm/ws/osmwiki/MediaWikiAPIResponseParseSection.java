package lig.steamer.of4osm.ws.osmwiki;

public class MediaWikiAPIResponseParseSection {

	private int toclevel;
	private int level;
	private String line;
	private String number;
	private String index;
	private String fromtitle;
	private int byteoffset;
	private String anchor;
	
	public int getToclevel() {
		return toclevel;
	}
	
	public void setToclevel(int toclevel) {
		this.toclevel = toclevel;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getIndex() {
		return index;
	}
	
	public void setIndex(String index) {
		this.index = index;
	}
	
	public String getFromtitle() {
		return fromtitle;
	}
	
	public void setFromtitle(String fromtitle) {
		this.fromtitle = fromtitle;
	}
	
	public int getByteoffset() {
		return byteoffset;
	}
	
	public void setByteoffset(int byteoffset) {
		this.byteoffset = byteoffset;
	}
	
	public String getAnchor() {
		return anchor;
	}
	
	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}
	
}
