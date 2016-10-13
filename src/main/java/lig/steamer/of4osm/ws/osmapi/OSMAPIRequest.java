package lig.steamer.of4osm.ws.osmapi;


/**
 *
 * @author amehiris
 */
public class OSMAPIRequest {

	public String lonMin;
	public String latMin;
	public String lonMax;
	public String latMax;
    
    public OSMAPIRequest(String lonMin , String latMin , String lonMax , String latMax) {
    	this.lonMin = lonMin;
    	this.latMin = latMin;
    	this.lonMax = lonMax;
    	this.latMax = latMax;
    }

	public String getLonMin() {
		return lonMin;
	}

	public void setLonMin(String lonMin) {
		this.lonMin = lonMin;
	}

	public String getLatMin() {
		return latMin;
	}

	public void setLatMin(String latMin) {
		this.latMin = latMin;
	}

	public String getLonMax() {
		return lonMax;
	}

	public void setLonMax(String lonMax) {
		this.lonMax = lonMax;
	}

	public String getLatMax() {
		return latMax;
	}

	public void setLatMax(String latMax) {
		this.latMax = latMax;
	}
    	
}
