package data.pressure;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Stateless
public class GetMinPressureForPolandLastUpdate {
    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double get(LocalDateTime lastUpdate){
        double min = stationDao.getMinPressureForPolandLastUpdate(lastUpdate).get(0).getStationPressure();
        return Double.parseDouble(df2.format(min));
    }
}
