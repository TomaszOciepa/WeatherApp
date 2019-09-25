package update;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMaxHumidityPolandDao;
import data.model.Station;
import data.model.StationMaxHumidityPoland;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class UpdateSaveMaxHumidityPoland {

    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxHumidityPolandDao stationMaxHumidityPolandDao;

    public void save(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        double maxHumidity = getMaxHumidity(lastUpdate);
        List<Station> stationsWithMaxHumidity = getCitiesMaxHumidity(maxHumidity, lastUpdate);

        for (int i = 0; i < stationsWithMaxHumidity.size(); i++) {

            stationMaxHumidityPolandDao.save(createMaxHumidityObj(stationsWithMaxHumidity.get(i)));
        }
    }

    private StationMaxHumidityPoland createMaxHumidityObj(Station station){
        StationMaxHumidityPoland stationMaxHumidityPoland = new StationMaxHumidityPoland();
        stationMaxHumidityPoland.setStationMaxHumidityPolandStationName(station.getStationName());
        stationMaxHumidityPoland.setStationMaxHumidityPolandStationNumber(station.getStationNumber());
        stationMaxHumidityPoland.setStationMaxHumidityPolandStationDateTime(station.getStationDateTime());
        stationMaxHumidityPoland.setStationMaxHumidityPolandStationHumidity(station.getStationHumidity());
        return stationMaxHumidityPoland;
    }

    private List<Station> getCitiesMaxHumidity(double maxHumidity, LocalDateTime lastUpdate){
        List<Station> stationWithMaxHumidity = stationDao.getCitiesWithHumidity(maxHumidity, lastUpdate);
        return stationWithMaxHumidity;
    }

    private double getMaxHumidity(LocalDateTime lastUpdate){
        double maxHumidity = stationDao.getMaxHumidityForPolandLastUpdate(lastUpdate).get(0).getStationHumidity();
        return maxHumidity;
    }
}
