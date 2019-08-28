package data;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Stateless
public class GetAverageTempDayForCity {

    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double get(LocalDate date, String city){

        double average;

        try {
            double sum = stationDao.getSumTempDayForCity(date, city).get(0);
            long count = stationDao.getCountTempDayForCity(date, city).get(0);
            average = sum / count;
        }catch (NullPointerException e){
            average = 0;
        }

        return Double.parseDouble(df2.format(average));
    }

}
