package data.humidity;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Stateless
public class GetMinHumidityForPolandLastUpdate {
    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double get(LocalDateTime lastUpdate){
        double min = stationDao.getMinHumidityForPolandLastMeasurement(lastUpdate).get(0).getStationHumidity();
        return Double.parseDouble(df2.format(min));
    }
}
