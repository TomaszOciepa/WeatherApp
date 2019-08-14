package api;

import javax.json.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeatherIMGW {

    private static final String IMGW_API = "https://danepubliczne.imgw.pl/api/data/synop";

    public List<String> getAllStations() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(IMGW_API);
        Response response = target.request().get();

        String restResponse = response.readEntity(String.class);
        response.close();

        InputStream inputStream = new ByteArrayInputStream(restResponse.getBytes());
        JsonReaderFactory readerFactory = Json.createReaderFactory(Collections.emptyMap());

        try (JsonReader jsonReader = readerFactory.createReader(inputStream)) {
            JsonArray jsonObject1 = jsonReader.readArray();

            List<String> cityName = new ArrayList<>();

            for (int i = 0; i < jsonObject1.size(); i++) {
                cityName.add(jsonObject1.getJsonObject(i).getString("stacja"));
            }

            return cityName;

        }

    }


}
