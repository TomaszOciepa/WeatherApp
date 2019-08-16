package api;

import javax.ejb.Stateless;
import javax.json.*;
import java.util.*;

@Stateless
public class GetCitiesList {

    public List<String> getCitiesName() {

        JsonFileAll jsonFileAll = new JsonFileAll();
        JsonArray jsonObject1 = jsonFileAll.getJson();

        List<String> citiesList = new ArrayList<>();
        for (int i = 0; i < jsonObject1.size(); i++) {
            String station_name = jsonObject1.getJsonObject(i).getString("stacja");
            citiesList.add(station_name);
        }

        return citiesList;
    }
}
