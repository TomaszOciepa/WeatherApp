package api;

import javax.json.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;

public class JsonFileStation {

    private static final String IMGW_API = "https://danepubliczne.imgw.pl/api/data/synop/id/";

    public JsonObject getCity(String id){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(IMGW_API+id);
        Response response = target.request().get();

        String restResponse = response.readEntity(String.class);
        response.close();

        InputStream inputStream = new ByteArrayInputStream(restResponse.getBytes());
        JsonReaderFactory readerFactory = Json.createReaderFactory(Collections.emptyMap());

        JsonObject jsonObject;
        try (JsonReader jsonReader = readerFactory.createReader(inputStream)) {
            jsonObject = jsonReader.readObject();

        }

        return jsonObject;
    }
}
