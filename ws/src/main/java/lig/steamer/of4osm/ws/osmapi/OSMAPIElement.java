package lig.steamer.of4osm.ws.osmapi;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public abstract class OSMAPIElement {

	private String id;
    private String timestamp;
    private String uid;
    private String user;
    private String version;
    private String visible;
    private String changeset;
    
	private List<OSMAPITag> tags;
	
	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	@XmlAttribute
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUid() {
		return uid;
	}

	@XmlAttribute
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUser() {
		return user;
	}

	@XmlAttribute
	public void setUser(String user) {
		this.user = user;
	}

	public String getVersion() {
		return version;
	}

	@XmlAttribute
	public void setVersion(String version) {
		this.version = version;
	}

	public String getVisible() {
		return visible;
	}

	@XmlAttribute
	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getChangeset() {
		return changeset;
	}
	
	@XmlAttribute
	public void setChangeset(String changeset) {
		this.changeset = changeset;
	}
	
	public List<OSMAPITag> getTags(){
		return tags;
	}
	
	@XmlElement(name="tag")
	public void setTags(List<OSMAPITag> tags){
		this.tags = tags;
	}
	
}
