package api;

import convert.DateConverter;
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
    private DateConverter dateConverter;

    public Station get(int id) {

        JsonObject objectJson = getJsonStation.getCity(id);

        CheckJsonIsNull checkJsonIsNull = new CheckJsonIsNull();

        int id_station = Integer.parseInt(checkJsonIsNull.checkJson("id_stacji", objectJson));
        String voivodshipCity = findVoivodshipCity(id_station);
        String voivodeship = addProvince(id_station);

        String name_station = checkJsonIsNull.checkJson("stacja", objectJson);

        String dateStr = checkJsonIsNull.checkJson("data_pomiaru", objectJson);
        LocalDate date = dateConverter.changeStringToLocalData(dateStr);

        int hour = Integer.parseInt(checkJsonIsNull.checkJson("godzina_pomiaru", objectJson));
        LocalTime time = LocalTime.of(hour, 0);
        LocalDateTime localDateTime = LocalDateTime.of(date, time);

        double temperature = Double.parseDouble(checkJsonIsNull.checkJson("temperatura", objectJson));
        int windSpeed = Integer.parseInt(checkJsonIsNull.checkJson("predkosc_wiatru", objectJson));
        int windDirection = Integer.parseInt(checkJsonIsNull.checkJson("kierunek_wiatru", objectJson));
        double pressure = Double.parseDouble(checkJsonIsNull.checkJson("cisnienie", objectJson));
        double humidity = Double.parseDouble(checkJsonIsNull.checkJson("wilgotnosc_wzgledna", objectJson));
        BigDecimal totalRainfall = new BigDecimal(checkJsonIsNull.checkJson("suma_opadu", objectJson));

        Station station = new Station(id_station, name_station, localDateTime, temperature, windSpeed, windDirection, pressure, humidity, totalRainfall, voivodshipCity, voivodeship);

        return station;
    }

    private String findVoivodshipCity(int id) {

        if (id == 12295 || id == 12424 || id == 12250 || id == 12495 || id == 12300 || id == 12465 || id == 12566 || id == 12375 || id == 12530 || id == 12580 ||
                id == 12155 || id == 12560 || id == 12570 || id == 12272 || id == 12330 || id == 12205) {
            return "yes";
        } else {
            return "no";
        }
    }

    private String addProvince(int id){
        if (id == 12500 || id == 12520 || id == 12415 || id == 12424){
            return "Dolnośląskie";
        }else if (id == 12250){
            return "Kujawsko-Pomorskie";
        } else if (id == 12495 || id == 12399 || id == 12497 || id == 12595){
            return "Lubelskie";
        }else if (id == 12300 || id == 12310 || id == 12400){
            return "Lubuskie";
        }else if (id == 12465 || id == 12469 || id == 12455){
            return "Łódzkie";
        }else if (id == 12566 || id == 12660 || id == 12575 || id == 12625){
            return "Małopolskie";
        }else if (id == 12488 || id == 12270 || id == 12360 || id == 12385 || id == 12375){
            return "Mazowieckie";
        } else if (id == 12530){
            return "Opolskie";
        }else if (id == 12670 || id == 12690 || id == 12695 || id == 12580){
            return "Podkarpackie";
        }else if (id == 12295 || id == 12195){
            return "Podlaskie";
        }else if (id == 12235 || id == 12155 || id == 12125 || id == 12120 || id == 12115){
            return "Pomorskie";
        }else if (id == 12600 || id == 12550 || id == 12560 || id == 12540){
            return "Śląskie";
        }else if (id == 12570 || id == 12585){
            return "Świętokrzyskie";
        }else if (id == 12160 || id == 12185 || id == 12280 || id == 12272){
            return "Warmińsko-Mazurskie";
        }else if (id == 12435 || id == 12345 || id == 12418 || id == 12230 || id == 12330){
            return "Wielkopolskie";
        }else if (id == 12100 || id == 12105 || id == 12210 || id == 12205 || id == 12215 || id == 12200){
            return "Zachodniopomorskie";
        }else {
            return "inne";
        }
    }
}
