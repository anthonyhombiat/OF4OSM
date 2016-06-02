/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.tagInfo;

/**
 * Get values used with a given key.
 *
 * @author amehiris
 */
public class KeyValuesData {

    //	Value
    private String value;
    // Number of times this key/value is in the OSM database.
    private int count;
    // Number of times in relation to number of times this key is in the OSM database.
    private float fraction;
    // 	Is there at least one wiki page for this tag.
    private boolean in_wiki;
    //  Description of the tag from the wiki.
    private String description;

    @Override
    public String toString() {
        return "{ \"value\" : " + value + ", \"count\" : " + count + ", \"fraction\" : " + fraction + ", \"in_wiki\" : " + in_wiki + ", \"description\" : " + description + "}\n";
    }

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

}
