package api;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;

public class JsonFileAll {

    private static final String IMGW_API = "https://danepubliczne.imgw.pl/api/data/synop";

    public JsonArray getJson(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(IMGW_API);
        Response response = target.request().get();

        String restResponse = response.readEntity(String.class);
        response.close();

        InputStream inputStream = new ByteArrayInputStream(restResponse.getBytes());
        JsonReaderFactory readerFactory = Json.createReaderFactory(Collections.emptyMap());

        JsonArray jsonObject;
        try (JsonReader jsonReader = readerFactory.createReader(inputStream)) {
            jsonObject = jsonReader.readArray();

        }

        return jsonObject;
    }
}
