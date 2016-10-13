package lig.steamer.of4osm.ws.overpass;


/**
 *
 * @author amehiris
 */
public class OverpassAPIRequest {

    public String bbox;
    public String typeElement;
    public String key;
    public String value;
    
    public OverpassAPIRequest(String bbox, String typeElement, String key, String value) {
    	this.bbox = bbox;
    	this.typeElement = typeElement;
    	this.key = key;
    	this.value = value;
    }

	public String getBbox() {
		return bbox;
	}

	public void setBbox(String bbox) {
		this.bbox = bbox;
	}

	public String getTypeElement() {
		return typeElement;
	}

	public void setTypeElement(String typeElement) {
		this.typeElement = typeElement;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
    
}
