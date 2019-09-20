package update;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMaxTempPolandDao;
import data.model.Station;
import data.model.StationMaxTempPoland;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class UpdateSaveMaxTempPoland {

    @Inject
    private StationDao stationDao;
    @Inject
    private StationMaxTempPolandDao stationMaxTempPolandDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;

    public void save(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        double maxTemp = getMaxTemp(lastUpdate);
        List<Station> stationsWithMaxTemp = getCitiesMaxTemp(maxTemp, lastUpdate);

        for (int i = 0; i < stationsWithMaxTemp.size(); i++) {
            stationMaxTempPolandDao.save(createMaxTempObj(stationsWithMaxTemp.get(i)));
        }
    }

    private StationMaxTempPoland createMaxTempObj(Station station){
        StationMaxTempPoland stationMaxTempPoland = new StationMaxTempPoland();
        stationMaxTempPoland.setStationMaxTempPolandStationNumber(station.getStationNumber());
        stationMaxTempPoland.setStationMaxTempPolandStationName(station.getStationName());
        stationMaxTempPoland.setStationMaxTempPolandStationTemperature(station.getStationTemperature());
        stationMaxTempPoland.setStationMaxTempPolandStationDateTime(station.getStationDateTime());
        return stationMaxTempPoland;
    }

    private List<Station> getCitiesMaxTemp(double maxTemp, LocalDateTime lastUpdate){
        List<Station> stationListWithMaxTemp = stationDao.getCitiesWithTemp(maxTemp, lastUpdate);
        return stationListWithMaxTemp;
    }

    private double getMaxTemp(LocalDateTime lastUpdate){
        double maxTemp = stationDao.getMaxTempForPolandLastUpdate(lastUpdate).get(0).getStationTemperature();
        return maxTemp;
    }

}
