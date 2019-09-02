package data.Temp;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

@Stateless
public class GetMinTempForCity {

    @Inject
    private StationDao stationDao;
    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double getMinTemp(String city){
        double minTemp = stationDao.getMinTempForCity(city).get(0).getStationTemperature();
        return Double.parseDouble(df2.format(minTemp));
    }

    public LocalDate getDate(String city){
        int year = stationDao.getMinTempForCity(city).get(0).getStationDateTime().getYear();
        int month = stationDao.getMinTempForCity(city).get(0).getStationDateTime().getMonthValue();
        int day = stationDao.getMinTempForCity(city).get(0).getStationDateTime().getDayOfMonth();

        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

    public LocalTime getHour(String city){
        int h = stationDao.getMinTempForCity(city).get(0).getStationDateTime().getHour();
        LocalTime hour = LocalTime.of(h, 0);
        return hour;
    }
}
