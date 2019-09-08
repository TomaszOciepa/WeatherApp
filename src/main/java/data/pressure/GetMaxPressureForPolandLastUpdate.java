package data.pressure;

import data.dao.StationDao;
import data.model.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class GetMaxPressureForPolandLastUpdate {
    @Inject
    private StationDao stationDao;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double get(LocalDateTime lastUpdate) {
        double max = stationDao.getMaxPressureForPolandLastMeasurement(lastUpdate).get(0).getStationPressure();
        return Double.parseDouble(df2.format(max));
    }


}
