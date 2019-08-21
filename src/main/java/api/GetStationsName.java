package api;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.*;
import java.util.*;

@Stateless
public class GetStationsName {

    @Inject
    private GetJsonAll getJsonAll;

    public List<String> get() {

        JsonArray jsonObject1 = getJsonAll.getJson();

        List<String> stationsList = new ArrayList<>();
        for (int i = 0; i < jsonObject1.size(); i++) {
            String station_name = jsonObject1.getJsonObject(i).getString("stacja");
            stationsList.add(station_name);
        }

        return stationsList;
    }
}
