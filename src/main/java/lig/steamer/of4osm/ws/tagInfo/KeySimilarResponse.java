/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.tagInfo;

import java.util.List;

/**
 *
 * @author amehiris
 */
public class KeySimilarResponse extends TagInfoResponse{
    
    private List<KeySimilarData> data;

    public List<KeySimilarData> getData() {
        return data;
    }

    public void setData(List<KeySimilarData> data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "{\"url\" : \"" + super.getUrl() + 
        		"\",\n \"data_until\" :\" " + super.getData_until() + 
        		"\", \"page\" : "+super.getPage() + 
        		", \"rp\" : " + super.getRp() + 
        		",\"total\": "+super.getTotal() +
        		",\n \"data\" : \n"+data+"}\n";
    }
}
