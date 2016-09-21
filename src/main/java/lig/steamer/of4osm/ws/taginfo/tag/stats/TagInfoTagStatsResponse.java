/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.taginfo.tag.stats;

import java.util.List;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponse;

/**
 *
 * @author amehiris
 */
public class TagInfoTagStatsResponse extends TagInfoResponse {

    private List<TagInfoTagStatsResponseData> data;

    public List<TagInfoTagStatsResponseData> getData() {
        return data;
    }

    public void setData(List<TagInfoTagStatsResponseData> data) {
        this.data = data;
    }
    
}
