package update;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMinPressurePolandDao;
import data.model.Station;
import data.model.StationMaxPressurePoland;
import data.model.StationMinPressurePoland;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class UpdateSaveMinPressurePoland {

    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMinPressurePolandDao stationMinPressurePolandDao;

    public void save(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        double minPressure = getMinPressure(lastUpdate);
        List<Station> stationsWithMinPressure = getCitiesMinPressure(minPressure, lastUpdate);

        for (int i = 0; i < stationsWithMinPressure.size(); i++) {
            stationMinPressurePolandDao.save(createMinPressureObj(stationsWithMinPressure.get(i)));
        }
    }

    private StationMinPressurePoland createMinPressureObj(Station station){
        StationMinPressurePoland stationMinPressurePoland = new StationMinPressurePoland();
        stationMinPressurePoland.setStationMinPressurePolandStationName(station.getStationName());
        stationMinPressurePoland.setStationMinPressurePolandStationNumber(station.getStationNumber());
        stationMinPressurePoland.setStationMinPressurePolandStationDateTime(station.getStationDateTime());
        stationMinPressurePoland.setStationMinPressurePolandStationPressure(station.getStationPressure());
        return stationMinPressurePoland;
    }

    private List<Station> getCitiesMinPressure(double minPressure, LocalDateTime lastUpdate){
        List<Station> stationList = stationDao.getCitiesWithPressure(minPressure, lastUpdate);
        return stationList;
    }
    private double getMinPressure(LocalDateTime lastUpdate){
        double minPressure = stationDao.getMinPressureForPolandLastUpdate(lastUpdate).get(0).getStationPressure();
        return minPressure;
    }
}
