package api;

import api.model.RestResponse;
import api.model.StationDetails;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class WeatherIMGW {

    private static final String IMGW_API = "https://danepubliczne.imgw.pl/api/data/synop/id/12235";

    public String getAllStations() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(IMGW_API );
        Response response = target.request().get();

        String restResponse = response.readEntity(String.class);
//        List<StationDetails> stationDetailsList = (List<StationDetails>) response.getEntity();
        response.close();


        InputStream inputStream = new ByteArrayInputStream(restResponse.getBytes());
        JsonReaderFactory readerFactory = Json.createReaderFactory(Collections.emptyMap());

        try (JsonReader jsonReader = readerFactory.createReader(inputStream)) {
            JsonObject jsonObject1 = jsonReader.readObject();
            return jsonObject1
                    .getString("stacja");

        }

//        return restResponse.toString();

//        return restResponse.getStationsResult().getResult();

//        restResponse.getStationsResult().getResult();

//        return restResponse.getStationsResult().getResult().get(1).getStation();


//        return stationDetailsList;

    }


}
