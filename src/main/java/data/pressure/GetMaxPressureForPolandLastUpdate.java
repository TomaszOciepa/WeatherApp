package data.pressure;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Stateless
public class GetMaxPressureForPolandLastUpdate {
    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double get(LocalDateTime lastUpdate) {
        double max = stationDao.getMaxPressureForPolandLastUpdate(lastUpdate).get(0).getStationPressure();
        return Double.parseDouble(df2.format(max));
    }


}
