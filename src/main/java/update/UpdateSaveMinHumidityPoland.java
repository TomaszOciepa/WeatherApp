package update;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMinHumidityPolandDao;
import data.model.Station;
import data.model.StationMinHumidityPoland;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class UpdateSaveMinHumidityPoland {

    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMinHumidityPolandDao stationMinHumidityPolandDao;

    public void save(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        double minHumidity = getMinHumidity(lastUpdate);
        List<Station> stationsWithMinHumidity = getCitiesMinHumidity(minHumidity, lastUpdate);

        for (int i = 0; i < stationsWithMinHumidity.size(); i++) {

            stationMinHumidityPolandDao.save(createMinHumidityObj(stationsWithMinHumidity.get(i)));
        }
    }

    private StationMinHumidityPoland createMinHumidityObj(Station station){
        StationMinHumidityPoland stationMinHumidityPoland = new StationMinHumidityPoland();
        stationMinHumidityPoland.setStationMinHumidityPolandStationName(station.getStationName());
        stationMinHumidityPoland.setStationMinHumidityPolandStationNumber(station.getStationNumber());
        stationMinHumidityPoland.setStationMinHumidityPolandStationDateTime(station.getStationDateTime());
        stationMinHumidityPoland.setStationMinHumidityPolandStationHumidity(station.getStationHumidity());
        return stationMinHumidityPoland;
    }

    private List<Station> getCitiesMinHumidity(double minHumidity, LocalDateTime lastUpdate){
        List<Station> stationWithMinHumidity = stationDao.getCitiesWithHumidity(minHumidity, lastUpdate);
        return stationWithMinHumidity;
    }

    private double getMinHumidity(LocalDateTime lastUpdate){
        double minHumidity = stationDao.getMinHumidityForPolandLastUpdate(lastUpdate).get(0).getStationHumidity();
        return minHumidity;
    }
}
