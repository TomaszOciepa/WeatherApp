package update;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMinRainPolandDao;
import data.model.Station;
import data.model.StationMinRainPoland;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class UpdateSaveMinRainPoland {

    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMinRainPolandDao stationMinRainPolandDao;

    public void save(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        BigDecimal minRain = getMinRain(lastUpdate);
        List<Station> stationsWithMinRain = getCitiesMinRain(minRain, lastUpdate);

        for (int i = 0; i < stationsWithMinRain.size(); i++) {
            stationMinRainPolandDao.save(createMinRainObj(stationsWithMinRain.get(i)));
        }

    }

    private StationMinRainPoland createMinRainObj(Station station){
        StationMinRainPoland stationMinRainPoland = new StationMinRainPoland();
        stationMinRainPoland.setStationMinRainPolandStationName(station.getStationName());
        stationMinRainPoland.setStationMinRainPolandStationNumber(station.getStationNumber());
        stationMinRainPoland.setStationMinRainPolandStationDateTime(station.getStationDateTime());
        stationMinRainPoland.setStationMinRainPolandStationRain(station.getStationTotalRainfall());
        return stationMinRainPoland;
    }

    private List<Station> getCitiesMinRain(BigDecimal minRain, LocalDateTime lastUpdate){
        List<Station> stationListWithMinRain = stationDao.getCitiesWithRainFall(minRain, lastUpdate);
        return stationListWithMinRain;
    }

    private BigDecimal getMinRain(LocalDateTime lastUpdate){
        BigDecimal minRain = stationDao.getMinRainFallForPolandLastUpdate(lastUpdate).get(0).getStationTotalRainfall();
        return minRain;
    }
}
