package update;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMaxWindPolandDao;
import data.model.Station;
import data.model.StationMaxWindPoland;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class UpdateSaveMaxWindPoland {

    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxWindPolandDao stationMaxWindPolandDao;

    public void save(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        int maxWind = getMaxWind(lastUpdate);
        List<Station>stationsWithMaxWind = getCitiesMaxWind(maxWind, lastUpdate);

        for (int i = 0; i < stationsWithMaxWind.size(); i++) {
            stationMaxWindPolandDao.save(createMaxWindObj(stationsWithMaxWind.get(i)));
        }

    }

    private StationMaxWindPoland createMaxWindObj(Station station){
        StationMaxWindPoland stationMaxWindPoland = new StationMaxWindPoland();
        stationMaxWindPoland.setStationMaxWindPolandStationName(station.getStationName());
        stationMaxWindPoland.setStationMaxWindPolandStationNumber(station.getStationNumber());
        stationMaxWindPoland.setStationMaxWindPolandStationDateTime(station.getStationDateTime());
        stationMaxWindPoland.setStationMaxWindPolandStationWind(station.getStationWindSpeed());

        return stationMaxWindPoland;
    }

    private List<Station> getCitiesMaxWind(int maxWind, LocalDateTime lastUpdate){
        List<Station> stationListWithMaxWind = stationDao.getCitiesWithWind(maxWind, lastUpdate);
        return stationListWithMaxWind;
    }

    private int getMaxWind(LocalDateTime lastUpdate){
        int maxWind = stationDao.getMaxWindForPolandLastUpdate(lastUpdate).get(0).getStationWindSpeed();
        return maxWind;
    }
}
