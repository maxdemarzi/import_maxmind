package com.maxdemarzi;

import com.maxdemarzi.imports.Locations;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.neo4j.harness.junit.Neo4jRule;
import org.neo4j.test.server.HTTP;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

public class ImportLocationsTest {
    @Rule
    public Neo4jRule neo4j = new Neo4jRule()
            .withExtension("/v1", Locations.class);

    @Test
    public void shouldImport() {
        HTTP.POST(neo4j.httpURI().resolve("/v1/schema/create").toString());

        URL url = this.getClass().getResource("/data/GeoLite2-City-Locations-en.csv");
        File file = new File(url.getFile());

        HashMap input = new HashMap<String, Object>() {{
            put("file", file.getAbsolutePath());
        }};
        HTTP.Response response = HTTP.POST(neo4j.httpURI().resolve("/v1/import/locations").toString(), input);
        HashMap actual = response.content();
        Assert.assertEquals(expected, actual);
    }


    private static final HashMap expected = new HashMap<String, Object>() {{
        put("Imported Locations Count", 102850);
    }};
}
