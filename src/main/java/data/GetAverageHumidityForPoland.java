package data;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;

@Stateless
public class GetAverageHumidityForPoland {
    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double get(){
        double sumHumidity = stationDao.getSumHumidityForPoland().get(0);
        long countHumidity = stationDao.getCountHumidityForPoland().get(0);
        double average = sumHumidity / countHumidity;
        return Double.parseDouble(df2.format(average));
    }
}
