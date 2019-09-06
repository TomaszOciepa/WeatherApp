package data.Temp;

import data.dao.StationDao;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;

@Stateless
public class GetMaxTempForPolandAllMeasurement {

    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double getMaxTemp(){
        double temp = stationDao.getMaxTempForPolandAllMeasurement().get(0).getStationTemperature();
        return Double.parseDouble(df2.format(temp));
    }

    public String getCity(){
        String stationName = stationDao.getMaxTempForPolandAllMeasurement().get(0).getStationName();
        return stationName;
    }

}
