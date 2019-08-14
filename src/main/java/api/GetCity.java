package api;

import api.model.CityDetails;

import javax.ejb.Stateless;
import javax.json.JsonObject;

@Stateless
public class GetCity {

    public CityDetails get(String id) {

        GetCityJsonFile getCityJsonFile = new GetCityJsonFile();
        JsonObject objectJson = getCityJsonFile.getJson(id);

        String id_station = objectJson.getString("id_stacji");
        String name_station = objectJson.getString("stacja");
        String date = objectJson.getString("data_pomiaru");
        String temperature = objectJson.getString("temperatura");

        CityDetails cityDetails = new CityDetails(id_station, name_station, date, temperature);

        return cityDetails;

    }
}
