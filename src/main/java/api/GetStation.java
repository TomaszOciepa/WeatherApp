package api;

import convert.DataConverter;
import data.model.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Stateless
public class GetStation {

    @Inject
    private GetJsonStation getJsonStation;
    @Inject
    private DataConverter dataConverter;

    public Station get(int id) {

        JsonObject objectJson = getJsonStation.getCity(id);

        CheckJsonIsNull checkJsonIsNull = new CheckJsonIsNull();

        int id_station = Integer.parseInt(checkJsonIsNull.checkJson("id_stacji", objectJson));
        String name_station = checkJsonIsNull.checkJson("stacja", objectJson);

        String dateStr = checkJsonIsNull.checkJson("data_pomiaru", objectJson);
        LocalDate date = dataConverter.ChangeStringToLocalData(dateStr);

        int hour = Integer.parseInt(checkJsonIsNull.checkJson("godzina_pomiaru", objectJson));
        LocalTime time = LocalTime.of(hour, 0);
        LocalDateTime localDateTime = LocalDateTime.of(date, time);

        double temperature = Double.parseDouble(checkJsonIsNull.checkJson("temperatura", objectJson));
        int windSpeed = Integer.parseInt(checkJsonIsNull.checkJson("predkosc_wiatru", objectJson));
        int windDirection = Integer.parseInt(checkJsonIsNull.checkJson("kierunek_wiatru", objectJson));
        double pressure = Double.parseDouble(checkJsonIsNull.checkJson("cisnienie", objectJson));
        double humidity = Double.parseDouble(checkJsonIsNull.checkJson("wilgotnosc_wzgledna", objectJson));
        BigDecimal totalRainfall = new BigDecimal(checkJsonIsNull.checkJson("suma_opadu", objectJson));

        Station station = new Station(id_station, name_station, localDateTime, temperature, windSpeed, windDirection, pressure, humidity, totalRainfall);

        return station;
    }
}
