package lig.steamer.of4osm.ws.taginfo;

/**
 *
 * @author amehiris
 */
public abstract class TagInfoResponse implements ITagInfoResponse {

    protected String url;
    private String data_until;
    private int page;
    private int rp;
    private int total;

    public String getUrl() {
        return url;
    }

    public String getData_until() {
        return data_until;
    }

    public int getPage() {
        return page;
    }

    public int getRp() {
        return rp;
    }

    public int getTotal() {
        return total;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setData_until(String data_until) {
        this.data_until = data_until;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRp(int rp) {
        this.rp = rp;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{\"url\" : \"" + this.getUrl() + 
        		"\",\n \"data_until\" :\" " + this.getData_until() +
        		"\", \"page\" : " + this.getPage() + 
        		", \"rp\" : " + this.getRp() + 
        		",\"total\": " + this.getTotal() + 
        		",\n \"data\" : \n" + this.getData() + "}\n";
    }
    
}
