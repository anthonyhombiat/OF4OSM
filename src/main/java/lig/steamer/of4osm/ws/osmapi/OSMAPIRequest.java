package lig.steamer.of4osm.ws.osmapi;

/**
 *
 * @author amehiris
 */
public class OSMAPIRequest {

	public double lonMin;
	public double latMin;
	public double lonMax;
	public double latMax;
    
    public OSMAPIRequest(double lonMin , double latMin , double lonMax , double latMax) {
    	this.lonMin = lonMin;
    	this.latMin = latMin;
    	this.lonMax = lonMax;
    	this.latMax = latMax;
    }

	public double getLonMin() {
		return lonMin;
	}

	public void setLonMin(double lonMin) {
		this.lonMin = lonMin;
	}

	public double getLatMin() {
		return latMin;
	}

	public void setLatMin(double latMin) {
		this.latMin = latMin;
	}

	public double getLonMax() {
		return lonMax;
	}

	public void setLonMax(double lonMax) {
		this.lonMax = lonMax;
	}

	public double getLatMax() {
		return latMax;
	}

	public void setLatMax(double latMax) {
		this.latMax = latMax;
	}
    	
}