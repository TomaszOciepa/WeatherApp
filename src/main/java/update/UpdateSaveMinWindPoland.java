package update;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMinWindPolandDao;
import data.model.Station;
import data.model.StationMinWindPoland;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class UpdateSaveMinWindPoland {

    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMinWindPolandDao stationMinWindPolandDao;

    public void save(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        int minWind = getMinWind(lastUpdate);
        List<Station> stationsWithMinWind = getCitiesMinWind(minWind, lastUpdate);

        for (int i = 0; i < stationsWithMinWind.size(); i++) {
            stationMinWindPolandDao.save(createMinWindObj(stationsWithMinWind.get(i)));
        }
    }

    private StationMinWindPoland createMinWindObj(Station station){
        StationMinWindPoland stationMinWindPoland = new StationMinWindPoland();
        stationMinWindPoland.setStationMinWindPolandStationName(station.getStationName());
        stationMinWindPoland.setStationMinWindPolandStationNumber(station.getStationNumber());
        stationMinWindPoland.setStationMinWindPolandStationDateTime(station.getStationDateTime());
        stationMinWindPoland.setStationMinWindPolandStationWind(station.getStationWindSpeed());
        return stationMinWindPoland;
    }

    private List<Station> getCitiesMinWind(int minWind, LocalDateTime lastUpdate){
        List<Station> stationsListWithMinWind = stationDao.getCitiesWithWind(minWind, lastUpdate);
        return stationsListWithMinWind;
    }

    private int getMinWind(LocalDateTime lastUpdate){
        int minWind = stationDao.getMinWindForPolandLastUpdate(lastUpdate).get(0).getStationWindSpeed();
        return minWind;
    }
}
