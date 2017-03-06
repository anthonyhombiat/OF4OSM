package lig.steamer.of4osm.ws.taginfo.key.values;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponseData;

/**
 * Get values used with a given key.
 *
 * @author amehiris
 */
public class TagInfoKeyValuesResponseData extends TagInfoResponseData {

    private String value;
    private int count;
    private float fraction;
    private boolean in_wiki;
    private String description;

    public String getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public float getFraction() {
        return fraction;
    }

    public boolean isIn_wiki() {
        return in_wiki;
    }

    public String getDescription() {
        return description;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
    }

    public void setIn_wiki(boolean in_wiki) {
        this.in_wiki = in_wiki;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "{ \"value\" : " + value + 
        		", \"count\" : " + count + 
        		", \"fraction\" : " + fraction + 
        		", \"in_wiki\" : " + in_wiki + 
        		", \"description\" : " + description + "}\n";
    }

}
