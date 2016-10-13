package lig.steamer.of4osm.ws.taginfo.key.stats;

import java.util.List;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponse;

/**
 *
 * @author amehiris
 */
public class TagInfoKeyStatsResponse extends TagInfoResponse {
    
    private List<TagInfoKeyStatsResponseData> data;

    public List<TagInfoKeyStatsResponseData> getData() {
        return data;
    }

    public void setData(List<TagInfoKeyStatsResponseData> data) {
        this.data = data;
    }
    
}
