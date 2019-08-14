package api;

import javax.ejb.Stateless;
import javax.json.*;
import java.util.*;

@Stateless
public class GetCitiesName {

    public List<String> getCitiesName() {

        List<String> citiesList = new ArrayList<>();

        GetAllJsonFile getAllJsonFile = new GetAllJsonFile();
        JsonArray jsonObject1 = getAllJsonFile.getJson();

        for (int i = 0; i < jsonObject1.size(); i++) {
            String station_name = jsonObject1.getJsonObject(i).getString("stacja");
            citiesList.add(station_name);
        }

        return citiesList;
    }
}
