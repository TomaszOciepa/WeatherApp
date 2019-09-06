package data.temp;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;

@Stateless
public class GetAverageTempMonthForCity {

    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double get(int month, String city){
        double average;

        try {
            double sum = stationDao.getSumTempMonthForCity(month, city).get(0);
            long count = stationDao.getCountTempMonthForCity(month, city).get(0);
            average = sum / count;
        }catch (NullPointerException e){
            average = 0;
        }

        return Double.parseDouble(df2.format(average));
    }
}
