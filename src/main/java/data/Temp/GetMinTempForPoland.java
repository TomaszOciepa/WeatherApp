package data.Temp;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;

@Stateless
public class GetMinTempForPoland {

    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double getMinTemp(){
        double minTemp = stationDao.getMinTempForPoland().get(0).getStationTemperature();
        return Double.parseDouble(df2.format(minTemp));
    }

    public String getCity(){
        String cityName = stationDao.getMinTempForPoland().get(0).getStationName();
        return cityName;
    }

}
