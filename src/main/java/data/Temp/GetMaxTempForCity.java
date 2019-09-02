package data.Temp;

import data.dao.StationDao;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;


@Stateless
public class GetMaxTempForCity {

    @Inject
    private StationDao stationDao;
    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double getMaxTemp(String city){

        double maxTemp = stationDao.getMaxTempForCity(city).get(0).getStationTemperature();
        return Double.valueOf(df2.format(maxTemp));
    }

    public LocalDate getDate(String city){
        int year = stationDao.getMaxTempForCity(city).get(0).getStationDateTime().getYear();
        int month = stationDao.getMaxTempForCity(city).get(0).getStationDateTime().getMonthValue();
        int day = stationDao.getMaxTempForCity(city).get(0).getStationDateTime().getDayOfMonth();

        LocalDate date = LocalDate.of(year, month, day);
        return date;

    }

    public LocalTime getTime(String city){
        int h = stationDao.getMaxTempForCity(city).get(0).getStationDateTime().getHour();
        LocalTime hour = LocalTime.of(h, 0);
        return hour;
    }
}
