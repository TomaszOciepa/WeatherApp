package data;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;

@Stateless
public class GetAveragePressureForPoland {

    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double get(){
        double sumPressure =  stationDao.getSumPreassureForPoland().get(0);
        long countPressure = stationDao.getCountPreassureForPoland().get(0);
        double average = sumPressure / countPressure;

        return Double.parseDouble(df2.format(average));
    }
}
