package data;

import data.dao.StationDao;
import data.model.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Stateless
public class GetLastUpdateDate {

    @Inject
    private StationDao stationDao;

    public LocalDateTime get(){
        List<Station> station = stationDao.lastUpdate();
        LocalDateTime date = station.get(0).getStationDateTime();
        return date;
    }

    public String getStringDateTime(){
        int year = this.get().getYear();
        int month = this.get().getMonthValue();
        int day = this.get().getDayOfMonth();
        int hour = this.get().getHour();

        LocalDate date = LocalDate.of(year,month,day);
        LocalTime time = LocalTime.of(hour, 0);
        String string = date+" "+ time;
        return string;
    }

    public String getStringDateDay(){
        int year = this.get().getYear();
        int month = this.get().getMonthValue();
        int day = this.get().getDayOfMonth();

        LocalDate date = LocalDate.of(year,month,day);
        String string = String.valueOf(date);
        return string;
    }

    public String getStringDateMonth(){
        int year = this.get().getYear();
        Month month = this.get().getMonth();

        String string = month+" "+year;
        return string;
    }
}
