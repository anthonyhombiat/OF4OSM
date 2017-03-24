# OF4OSM: Ontology from Folksonomy for OpenStreetMap

*Model, method and tools for building a knowledge base from the [OpenStreetMap] folksonomy: the OF4OSM ontology.*

## Principle

**OpenStreetMap** (OSM) is a **citizen science** project that aims at building a **spatial database of the World**. The geographic features represented in this database (buildings, highways, land use, etc.) are described via geometries (points, ways and polygones) and attributes by the OSM community. The attributes, also called **tags**, are represented by a **key=value** pair. For instance, `amenity=school` describes a school. The OSM folksonomy is the **unstructured** bag that contains all these OSM tags. Tags are very convenient to use for the OSM contributors. However, the lack of structure inherent to the OSM folksonomy is a major obstacle both for data acquisition and data retrieval. The OF4OSM project aims at **semantically lifting the OSM folksonomy into an OSM knowledge base** under the form of an ontology : **OF4OSM**.

What the OF4OSM project does:
1. Takes a bounding box (bbox) as input
2. Retrieves OSM tags on the given bbox
3. Outputs an ontology axtracted from the retrieved OSM tags

## Download

Download the Java archive from the GitHub repository: [of4osm.jar]

## Usage

How to use it:

1. Find the bbox of your study area. The [boundingbox.klokantech.com] Web site can help here. The bbox must be of the form `bbox1 bbox2 bbox3 bbox4`. For example, the bbox enclosing Grenoble is: `5.677606 45.15414 5.753118 45.214077`

2. Launch the OF4OSM jar giving the bbox from a terminal:   
`java -jar of4osm.jar "bbox1 bbox2 bbox3 bbox4"`   
For example, for Grenoble:   
`java -jar of4osm.jar "5.677606 45.15414 5.753118 45.214077"`   

3. Open the output ontology in your current directory with your favorite ontology editor ([Protégé] can help here).

## Modules

OF4OSM is a multi-modules project composed of the following submodules:

* **CORE**: Model and default implementation of the OF4OSM project   
[of4osm-core]

* **DISTRIB**: The distribution module for building a single-jar of the whole OF4OSM project   
[of4osm-distrib]

* **IMPL**: Default implementation of the of4osm-core module   
[of4osm-impl]

* **TOOLS**: Tools for manipulating the OSM folksonomy and OF4OSM ontology   
[of4osm-tools]

* **WS**: Tools for querying OpenStreetMap oriented Web Services   
[of4osm-ws]

[OpenStreetMap]:https://www.openstreetmap.org/
[of4osm-parent]:https://github.com/anthonyhombiat/OF4OSM
[of4osm-core]:https://github.com/anthonyhombiat/OF4OSM/tree/master/core
[of4osm-distrib]:https://github.com/anthonyhombiat/OF4OSM/tree/master/distrib
[of4osm-impl]:https://github.com/anthonyhombiat/OF4OSM/tree/master/impl
[of4osm-tools]:https://github.com/anthonyhombiat/OF4OSM/tree/master/tools
[of4osm-ws]:https://github.com/anthonyhombiat/OF4OSM/tree/master/ws
[boundingbox.klokantech.com]:http://boundingbox.klokantech.com/
[Protégé]:http://protege.stanford.edu/
[of4osm.jar]:http://github.com/anthonyhombiat/OF4OSM/raw/master/distrib/target/of4osm.jar
