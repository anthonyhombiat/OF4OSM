package lig.steamer.of4osm.ws.osmwiki;

public enum MediaWikiAPIProperty {

	SECTIONS("sections"),
	TEXT("text");

    private final String text;

    /**
     * @param text
     */
    private MediaWikiAPIProperty(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
	
}
