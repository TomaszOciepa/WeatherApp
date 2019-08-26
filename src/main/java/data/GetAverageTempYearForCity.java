package data;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;

@Stateless
public class GetAverageTempYearForCity {

    @Inject
    private StationDao stationDao;
    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double get(int year, String station) {
        double average;

        try {
            double sum = stationDao.getSumTempYearForCity(year, station).get(0);
            long count = stationDao.getCountTempYearForCity(year, station).get(0);
            average = sum / count;
        }catch (NullPointerException e){
            average = 0;
        }

        return Double.parseDouble(df2.format(average));
    }
}
