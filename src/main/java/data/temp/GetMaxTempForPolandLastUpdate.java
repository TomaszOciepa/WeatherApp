package data.temp;

import data.GetLastUpdateDate;
import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Stateless
public class GetMaxTempForPolandLastUpdate {

    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public double getTemp(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        double maxTemp = stationDao.getMaxTempForPolandLastMeasurement(lastUpdate).get(0).getStationTemperature();
        return Double.parseDouble(df2.format(maxTemp));
    }

}
