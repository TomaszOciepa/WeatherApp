package api;

import api.model.CityDetails;
import convert.DataConverter;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Stateless
public class GetCity {

    public CityDetails get(String id) {

        JsonFileStation jsonFileStation = new JsonFileStation();
        JsonObject objectJson = jsonFileStation.getCity(id);

        CheckJsonIsNull checkJsonIsNull = new CheckJsonIsNull();

        int id_station = Integer.parseInt(checkJsonIsNull.checkJson("id_stacji", objectJson));
        String name_station = checkJsonIsNull.checkJson("stacja", objectJson);

        String dateStr = checkJsonIsNull.checkJson("data_pomiaru", objectJson);
        DataConverter dataConverter = new DataConverter();
        LocalDate date = dataConverter.ChangeStringToLocalData(dateStr);

        int hour = Integer.parseInt(checkJsonIsNull.checkJson("godzina_pomiaru", objectJson));
        LocalTime time = LocalTime.of(hour, 0);
        double temperature = Double.parseDouble(checkJsonIsNull.checkJson("temperatura", objectJson));
        int windSpeed = Integer.parseInt(checkJsonIsNull.checkJson("predkosc_wiatru", objectJson));
        int windDirection = Integer.parseInt(checkJsonIsNull.checkJson("kierunek_wiatru", objectJson));
        double pressure = Double.parseDouble(checkJsonIsNull.checkJson("cisnienie", objectJson));
        double humidity = Double.parseDouble(checkJsonIsNull.checkJson("wilgotnosc_wzgledna", objectJson));
        BigDecimal totalRainfall = new BigDecimal(checkJsonIsNull.checkJson("suma_opadu", objectJson));

        CityDetails cityDetails = new CityDetails(id_station, name_station, date, time, temperature, windSpeed, windDirection, pressure, humidity, totalRainfall);

        return cityDetails;
    }
}
