package api;

import api.model.CityDetails;

import javax.ejb.Stateless;
import javax.json.JsonObject;

@Stateless
public class GetCity {

    public CityDetails get(String id) {

        JsonFileStation jsonFileStation = new JsonFileStation();
        JsonObject objectJson = jsonFileStation.getCity(id);

        CheckJsonIsNull checkJsonIsNull = new CheckJsonIsNull();

        String id_station = checkJsonIsNull.checkJson("id_stacji", objectJson);
        String name_station = checkJsonIsNull.checkJson("stacja", objectJson);
        String date = checkJsonIsNull.checkJson("data_pomiaru", objectJson);
        String hour = checkJsonIsNull.checkJson("godzina_pomiaru", objectJson);
        String temperature = checkJsonIsNull.checkJson("temperatura", objectJson);
        String windSpeed = checkJsonIsNull.checkJson("predkosc_wiatru", objectJson);
        String windDirection = checkJsonIsNull.checkJson("kierunek_wiatru", objectJson);
        String pressure = checkJsonIsNull.checkJson("cisnienie", objectJson);
        String humidity = checkJsonIsNull.checkJson("wilgotnosc_wzgledna", objectJson);
        String totalRainfall = checkJsonIsNull.checkJson("suma_opadu", objectJson);

        CityDetails cityDetails = new CityDetails(id_station, name_station, date, hour, temperature, windSpeed, windDirection, pressure, humidity, totalRainfall);

        return cityDetails;
    }
}
