package data;

import data.dao.StationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GetAverageWindSpeedForPoland {

    @Inject
    private StationDao stationDao;

    public long get(){
        long sumWindSpeed = stationDao.getSumWindSpeedForPoland().get(0);
        long countWindSpeed = stationDao.getCountWindSpeedForPoland().get(0);
        long average = sumWindSpeed / countWindSpeed;
        return average;
    }
}
