package data.temp;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Stateless
public class GetMinTempForPolandLastUpdate {
    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double getTemp(LocalDateTime lastUpdate){
        double maxTemp = stationDao.getMinTempForPolandLastUpdate(lastUpdate).get(0).getStationTemperature();
        return Double.parseDouble(df2.format(maxTemp));
    }

}
