/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.tagInfo;

/**
 *
 * @author amehiris
 */
public class KeyStatsData {

    //Object type ("all", "nodes", "ways", or "relations")
    private String type;
    //Number of objects with this type and key.
    private int count;
    //Number of objects in relation to all objects.
    private float count_fraction;
    //	Number of different values for this key.
    private int values;
    
    @Override
    public String toString()
    {
        return "{ \"type\" : "+type+ ", \"count\" : "+count+", \"count_fraction\" : "+count_fraction+", \"values\" : "+values+"}\n";
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public float getCount_fraction() {
        return count_fraction;
    }

    public int getValues() {
        return values;
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

    public void setValues(int values) {
        this.values = values;
    }
    
    

}
