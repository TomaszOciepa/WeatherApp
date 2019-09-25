package update;


import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMaxRainPolandDao;
import data.model.Station;
import data.model.StationMaxRainPoland;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class UpdateSaveMaxRainPoland {

    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxRainPolandDao stationMaxRainPolandDao;

    public void save(){
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        BigDecimal maxRain = getMaxRain(lastUpdate);
        List<Station> stationsWithMaxRain = getCitiesMaxRain(maxRain, lastUpdate);

        for (int i = 0; i < stationsWithMaxRain.size(); i++) {
            stationMaxRainPolandDao.save(createMaxRainObj(stationsWithMaxRain.get(i)));
        }
    }

    private StationMaxRainPoland createMaxRainObj(Station station){
        StationMaxRainPoland stationMaxRainPoland = new StationMaxRainPoland();
        stationMaxRainPoland.setStationMaxRainPolandStationName(station.getStationName());
        stationMaxRainPoland.setStationMaxRainPolandStationNumber(station.getStationNumber());
        stationMaxRainPoland.setStationMaxRainPolandStationDateTime(station.getStationDateTime());
        stationMaxRainPoland.setStationMaxRainPolandStationRain(station.getStationTotalRainfall());

        return stationMaxRainPoland;
    }

    private List<Station> getCitiesMaxRain(BigDecimal maxRain, LocalDateTime lastUpdate){
        List<Station> stationListWithMaxRain = stationDao.getCitiesWithRainFall(maxRain, lastUpdate);
        return stationListWithMaxRain;
    }

    private BigDecimal getMaxRain(LocalDateTime lastUpdate){
        BigDecimal maxRain = stationDao.getMaxRainFallForPolandLastUpdate(lastUpdate).get(0).getStationTotalRainfall();
        return maxRain;
    }
}
