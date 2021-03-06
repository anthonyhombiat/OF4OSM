package lig.steamer.of4osm.ws.taginfo.tag.stats;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponseData;

/**
 * Show some database statistics for given tag.
 *
 * @author amehiris
 */
public class TagInfoTagStatsResponseData extends TagInfoResponseData {

    private String type;
    private int count;
    private float count_fraction;

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public float getCount_fraction() {
        return count_fraction;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCount_fraction(float count_fraction) {
        this.count_fraction = count_fraction;
    }
    
    @Override
    public String toString() {
        return "{ \"type\" : " + type + 
        		", \"count\" : " + count + 
        		", \"count_fraction\" : " + count_fraction + "}\n";
    }
    
}
