package data.wind;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Stateless
public class GetMinWindForPolandLastUpdate {
    @Inject
    private StationDao stationDao;


    public int get(LocalDateTime lastUpdate) {

        int maxWind = stationDao.getMinWindForPolandLastMeasurement(lastUpdate).get(0).getStationWindSpeed();
        return maxWind;
    }

}
