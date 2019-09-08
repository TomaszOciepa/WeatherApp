package data;

import data.dao.StationDao;
import data.model.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class GetVoivodshipCity {

    @Inject
    private StationDao stationDao;


    public List<Station> get(LocalDateTime localDateTime){
        List<Station> stationList = stationDao.getVoivodshipCityTemp(localDateTime);
        return stationList;
    }


//    public List<String> parseToString(List<Station> stationList){
//        String city;
//        String temp;
//
//        for (int i = 0; i < stationList.size(); i++) {
//
//        }
//    }
}
