package lig.steamer.of4osm.ws.osmwiki;

public enum OSMWikiAction {

	PARSE("parse");

    private final String text;

    /**
     * @param text
     */
    private OSMWikiAction(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
	
}
