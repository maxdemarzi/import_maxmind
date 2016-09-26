# import_maxmind

Import the MaxMind Cities Database into Neo4j

# Instructions

1. Build it:

        mvn clean package

2. Copy target/importer-1.0-SNAPSHOT.jar to the plugins/ directory of your Neo4j server.

3. Download and copy additional jars to the plugins/ directory of your Neo4j server.
        
        wget http://central.maven.org/maven2/org/apache/commons/commons-csv/1.2/commons-csv-1.2.jar

4. Configure Neo4j by adding a line to conf/neo4j.conf:

        dbms.unmanaged_extension_classes=com.maxdemarzi=/v1

5. Start Neo4j server.


6. Create the schema:

        :POST /v1/schema/create

7. Import the CSV files:

        :POST /v1/import/locations {"file":"path to file"}
        # for example:
        :POST /v1/import/locations {"file":"/Users/maxdemarzi/Projects/import_maxmind/src/main/resources/data/GeoLite2-City-Locations-en.csv"}
        
        
This product includes GeoLite2 data created by MaxMind, available from <a href="http://www.maxmind.com">http://www.maxmind.com</a>.        
