package data.rainfall;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Stateless
public class GetMinRainFallForPolandLastUpdate {
    @Inject
    private StationDao stationDao;

    public BigDecimal get(LocalDateTime lastUpdate){
        BigDecimal maxRainFall = stationDao.getMinRainFallForPolandLastUpdate(lastUpdate).get(0).getStationTotalRainfall();
        return maxRainFall;
    }
}
