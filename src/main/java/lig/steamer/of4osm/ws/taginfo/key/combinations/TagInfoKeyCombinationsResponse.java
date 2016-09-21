/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.taginfo.key.combinations;

import java.util.List;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponse;

/**
 *
 * @author amehiris
 */
public class TagInfoKeyCombinationsResponse extends TagInfoResponse {
    
    private List<TagInfoKeyCombinationsResponseData> data;

    public List<TagInfoKeyCombinationsResponseData> getData() {
        return data;
    }

    public void setData(List<TagInfoKeyCombinationsResponseData> data) {
        this.data = data;
    }
}
