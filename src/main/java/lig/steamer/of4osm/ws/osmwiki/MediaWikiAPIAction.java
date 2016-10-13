package lig.steamer.of4osm.ws.osmwiki;

public enum MediaWikiAPIAction {

	PARSE("parse");

    private final String text;

    /**
     * @param text
     */
    private MediaWikiAPIAction(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
	
}
