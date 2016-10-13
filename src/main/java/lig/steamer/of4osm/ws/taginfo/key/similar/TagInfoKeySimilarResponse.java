package lig.steamer.of4osm.ws.taginfo.key.similar;

import java.util.List;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponse;

/**
 *
 * @author amehiris
 */
public class TagInfoKeySimilarResponse extends TagInfoResponse{
    
    private List<TagInfoKeySimilarResponseData> data;

    public List<TagInfoKeySimilarResponseData> getData() {
        return data;
    }

    public void setData(List<TagInfoKeySimilarResponseData> data) {
        this.data = data;
    }
}
