package update;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMaxPressurePolandDao;
import data.model.Station;
import data.model.StationMaxPressurePoland;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class UpdateSaveMaxPressurePoland {

    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxPressurePolandDao stationMaxPressurePolandDao;

    public void save(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        double maxPressure = getMaxPressure(lastUpdate);
        List<Station> stationsWithMaxPressure = getCitiesMaxPressure(maxPressure, lastUpdate);

        for (int i = 0; i < stationsWithMaxPressure.size(); i++) {
            stationMaxPressurePolandDao.save(createMaxPressureObj(stationsWithMaxPressure.get(i)));
        }
    }

    private StationMaxPressurePoland createMaxPressureObj(Station station){
        StationMaxPressurePoland stationMaxPressurePoland = new StationMaxPressurePoland();
        stationMaxPressurePoland.setStationMaxPressurePolandStationName(station.getStationName());
        stationMaxPressurePoland.setStationMaxPressurePolandStationNumber(station.getStationNumber());
        stationMaxPressurePoland.setStationMaxPressurePolandStationDateTime(station.getStationDateTime());
        stationMaxPressurePoland.setStationMaxPressurePolandStationPressure(station.getStationPressure());
        return stationMaxPressurePoland;
    }

    private List<Station> getCitiesMaxPressure(double maxPressure, LocalDateTime lastUpdate){
        List<Station> stationList = stationDao.getCitiesWithPressure(maxPressure, lastUpdate);
        return stationList;
    }
    private double getMaxPressure(LocalDateTime lastUpdate){
        double maxPressure = stationDao.getMaxPressureForPolandLastUpdate(lastUpdate).get(0).getStationPressure();
        return maxPressure;
    }
}
