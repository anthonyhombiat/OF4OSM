package lig.steamer.of4osm.ws.overpass;

/**
 *
 * @author amehiris
 */

public class OverpassAPIOsm3s {
    
    private String timestamp_osm_base;
    private String copyright;

    public String getTimestamp_osm_base() {
        return timestamp_osm_base;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setTimestamp_osm_base(String timestamp_osm_base) {
        this.timestamp_osm_base = timestamp_osm_base;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        return "{\"timestamp_osm_base\" : \""+timestamp_osm_base+"\",\n \"copyright\" :\" "+copyright+"}\n";
    }
    
}
