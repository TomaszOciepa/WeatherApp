package data;

import data.dao.StationDao;
import data.model.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class GetLastUpdateDate {

    @Inject
    private StationDao stationDao;

    public LocalDateTime get(){
        List<Station> station = stationDao.lastUpdate();
        LocalDateTime date = station.get(0).getStationDateTime();

        return date;
    }
}
