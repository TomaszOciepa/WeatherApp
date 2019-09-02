package data.Temp;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;

@Stateless
public class GetAverageTempForPoland {

    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double get(){

        double sumTemp = stationDao.getSumTempForPoland().get(0);
        long count = stationDao.getCountTempForPoland().get(0);
        double average = sumTemp / count;

        return Double.parseDouble(df2.format(average));
    }
}
