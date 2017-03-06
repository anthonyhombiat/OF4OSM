package lig.steamer.of4osm.tools.parse;

public class OF4OSMFolkso2OntoParserConfig {

	private boolean parseSimpleCategoryTags;
	private boolean parseStatefulCategoryTags;
	private boolean parseMultipleCategoryTags;
	private boolean parseBooleanPropertyTags;
	
	public OF4OSMFolkso2OntoParserConfig(boolean parseSimpleCategoryTags, boolean parseStatefulCategoryTags, boolean parseMultipleCategoryTags, boolean parseBooleanPropertyTags){
		this.parseSimpleCategoryTags = parseSimpleCategoryTags;
		this.parseStatefulCategoryTags = parseStatefulCategoryTags;
		this.parseMultipleCategoryTags = parseMultipleCategoryTags;
		this.parseBooleanPropertyTags = parseBooleanPropertyTags;
	}
	
	public OF4OSMFolkso2OntoParserConfig(){
		this(true, true, true, false);
	}

	public boolean isParseSimpleCategoryTags() {
		return parseSimpleCategoryTags;
	}

	public void setParseSimpleCategoryTags(boolean parseSimpleCategoryTags) {
		this.parseSimpleCategoryTags = parseSimpleCategoryTags;
	}

	public boolean isParseStatefulCategoryTags() {
		return parseStatefulCategoryTags;
	}

	public void setParseStatefulCategoryTags(boolean parseStatefulCategoryTags) {
		this.parseStatefulCategoryTags = parseStatefulCategoryTags;
	}

	public boolean isParseMultipleCategoryTags() {
		return parseMultipleCategoryTags;
	}

	public void setParseMultipleCategoryTags(boolean parseMultipleCategoryTags) {
		this.parseMultipleCategoryTags = parseMultipleCategoryTags;
	}

	public boolean isParseBooleanPropertyTags() {
		return parseBooleanPropertyTags;
	}

	public void setParseBooleanPropertyTags(boolean parseBooleanPropertyTags) {
		this.parseBooleanPropertyTags = parseBooleanPropertyTags;
	}
	
}