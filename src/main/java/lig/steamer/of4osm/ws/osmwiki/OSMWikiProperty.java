package lig.steamer.of4osm.ws.osmwiki;

public enum OSMWikiProperty {

	SECTIONS("sections"),
	TEXT("text");

    private final String text;

    /**
     * @param text
     */
    private OSMWikiProperty(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
	
}
