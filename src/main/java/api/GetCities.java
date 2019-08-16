package api;

import api.model.City;

import javax.json.JsonArray;
import java.util.ArrayList;
import java.util.List;

public class GetCities {

    public List<City> get(){

        JsonFileAll jsonFileAll = new JsonFileAll();
        JsonArray jsonObject1 = jsonFileAll.getJson();

        List<City> cityList = new ArrayList<>();
        for (int i = 0; i < jsonObject1.size(); i++) {
            String id = jsonObject1.getJsonObject(i).getString("id_stacji");
            String name = jsonObject1.getJsonObject(i).getString("stacja");
            City city = new City(id, name);
            cityList.add(city);
        }
        return cityList;
    }
}
