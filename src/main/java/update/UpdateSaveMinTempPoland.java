package update;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMinTempPolandDao;
import data.model.Station;
import data.model.StationMinTempPoland;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class UpdateSaveMinTempPoland {

    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMinTempPolandDao stationMinTempPolandDao;

    public void save(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        double minTemp = getMinTemp(lastUpdate);
        List<Station> stationsWithMinTemp = getCitiesMinTemp(minTemp, lastUpdate);

        for (int i = 0; i < stationsWithMinTemp.size(); i++) {
            stationMinTempPolandDao.save(createMinTempObj(stationsWithMinTemp.get(i)));
        }

    }

    private StationMinTempPoland createMinTempObj(Station station){
        StationMinTempPoland stationMinTempPoland = new StationMinTempPoland();
        stationMinTempPoland.setStationMinTempPolandStationName(station.getStationName());
        stationMinTempPoland.setStationMinTempPolandStationNumber(station.getStationNumber());
        stationMinTempPoland.setStationMinTempPolandStationDateTime(station.getStationDateTime());
        stationMinTempPoland.setStationMinTempPolandStationTemperature(station.getStationTemperature());
        return stationMinTempPoland;
    }

    private List<Station> getCitiesMinTemp(double minTemp, LocalDateTime lastUpdate){
        List<Station> stationsListWithMinTemp = stationDao.getCitiesWithTemp(minTemp, lastUpdate);
        return stationsListWithMinTemp;
    }

    private double getMinTemp(LocalDateTime lastUpdate){
        double minTemp = stationDao.getMinTempForPolandLastUpdate(lastUpdate).get(0).getStationTemperature();
        return minTemp;
    }
}
