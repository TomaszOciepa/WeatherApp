package data.wind;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Stateless
public class GetMaxWindForPolandLastUpdate {
    @Inject
    private StationDao stationDao;

    public int get(LocalDateTime lastUpdate) {

        int maxWind = stationDao.getMaxWindForPolandLastUpdate(lastUpdate).get(0).getStationWindSpeed();
        return maxWind;
    }

}
