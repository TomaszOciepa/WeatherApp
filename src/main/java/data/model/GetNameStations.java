package data.model;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class GetNameStations {
    @Inject
    private StationDao stationDao;


    public List<String> get(){
        List<String> stringList = stationDao.getCitiesName();
        List<String> uniqueNames = stringList.stream().distinct().collect(Collectors.toList());
        return uniqueNames;
    }
}
