package data;

import data.dao.StationDao;
import data.model.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GetMaxTempForLast48h {

    @Inject
    private StationDao stationDao;

    public List<Station> get(LocalDateTime lastupdate){
        double maxtemp = 0;
        List<Station> stationsList = new ArrayList<>();
        LocalDateTime time = lastupdate.minusHours(1);

        for (int i = 0; i < 48; i++) {
            if (i == 0){
                maxtemp = stationDao.getMaxTempForPolandLastUpdate(lastupdate).get(0).getStationTemperature();
                List<Station> list = stationDao.getCitiesWithTemp(maxtemp, lastupdate);
                for (int j = 0; j < list.size(); j++) {
                    stationsList.add(list.get(j));
                }
            } else {

                if (stationDao.getMaxTempForPolandLastUpdate(time).size() != 0){
                    maxtemp = stationDao.getMaxTempForPolandLastUpdate(time).get(0).getStationTemperature();
                    List<Station> list = stationDao.getCitiesWithTemp(maxtemp, time);
                    for (int j = 0; j < list.size(); j++) {
                        stationsList.add(list.get(j));
                    }
                }else {
                    Station noMeasurement = new Station();
                    noMeasurement.setStationDateTime(time);
                    noMeasurement.setStationName("Brak pomiaru");
                    stationsList.add(noMeasurement);
                }

            }
            time = time.minusHours(1);
        }
        return stationsList;
    }
}
