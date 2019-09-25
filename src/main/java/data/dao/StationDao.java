package data.dao;

import data.model.Station;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Stateless
public class StationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(Station station) {
        entityManager.persist(station);
        return station.getStationId();
    }

    public Station update(Station station) {
        return entityManager.merge(station);
    }

    public void delete(long id) {
        final Station city = entityManager.find(Station.class, id);
        if (city != null) {
            entityManager.remove(city);
        }
    }

    public Station findById(long id) {
        return entityManager.find(Station.class, id);
    }

    public List<Station> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Station s");

        return (List<Station>) query.getResultList();
    }

    public List<Station> getSelectedCity(String city) {
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationName = :city");
        query.setParameter("city", city);

        return (List<Station>) query.getResultList();
    }

    public List<String> getCitiesName() {
        final Query query = entityManager.createQuery("SELECT s.stationName FROM Station s");
        return (List<String>) query.getResultList();
    }

    public List<Station> lastUpdate() {
        final Query query = entityManager.createQuery("SELECT s FROM Station s ORDER BY s.stationDateTime DESC");
        return (List<Station>) query.getResultList();
    }


//    Voivodship City
    public List<Station> getVoivodshipCityTemp(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :localDateTime AND s.stationVoivodshipCity = :voivodshipCity ORDER BY s.stationTemperature DESC");
        query.setParameter("localDateTime", localDateTime);
        query.setParameter("voivodshipCity", "vcity");
        return (List<Station>) query.getResultList();
    }

//    Station
    public List<Station> getStationDataForHour(String stationName, LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM  Station s WHERE s.stationName = :stationName AND s.stationDateTime = :localDateTime");
        query.setParameter("stationName", stationName);
        query.setParameter("localDateTime", localDateTime);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getStationDataForDay(String stationName, LocalDateTime startDay, LocalDateTime endDay){
        final  Query query = entityManager.createQuery("SELECT s FROM Station s WHERE  s.stationName = :stationName AND s.stationDateTime BETWEEN :startDay AND :endDay ORDER BY s.stationDateTime ASC");
        query.setParameter("stationName", stationName);
        query.setParameter("startDay",  startDay);
        query.setParameter("endDay",  endDay);
        return (List<Station>) query.getResultList();
    }


//        Poland
    public List<Station> getMaxTempForPolandLastUpdate(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationDateTime = :lastUpdate ORDER BY s.stationTemperature DESC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinTempForPolandLastUpdate(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationDateTime = :lastUpdate ORDER BY s.stationTemperature ASC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMaxWindForPolandLastUpdate(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationDateTime = :lastUpdate ORDER BY s.stationWindSpeed DESC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinWindForPolandLastUpdate(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND  s.stationDateTime = :lastUpdate AND s.stationWindSpeed > 0 ORDER BY s.stationWindSpeed ASC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMaxRainFallForPolandLastUpdate(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE  (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationDateTime = :lastUpdate ORDER BY s.stationTotalRainfall DESC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinRainFallForPolandLastUpdate(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationDateTime = :lastUpdate AND s.stationTotalRainfall > 0 ORDER BY s.stationTotalRainfall ASC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMaxHumidityForPolandLastUpdate(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationDateTime = :lastUpdate ORDER BY s.stationHumidity DESC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinHumidityForPolandLastUpdate(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationDateTime = :lastUpdate ORDER BY s.stationHumidity ASC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMaxPressureForPolandLastUpdate(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationDateTime = :lastUpdate ORDER BY s.stationPressure DESC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinPressureForPolandLastUpdate(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE  (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationDateTime = :lastUpdate AND s.stationPressure > 0 ORDER BY s.stationPressure ASC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getCitiesWithTemp(double temp, LocalDateTime time){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationTemperature = :temp AND s.stationDateTime = :time");
        query.setParameter("temp", temp);
        query.setParameter("time", time);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getCitiesWithWind(int wind, LocalDateTime time){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE  (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationWindSpeed = :wind AND s.stationDateTime = :time");
        query.setParameter("wind", wind);
        query.setParameter("time", time);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        return (List<Station>) query.getResultList();
    }

    public List<Station> getCitiesWithRainFall(BigDecimal rain, LocalDateTime time){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationTotalRainfall = :rain AND s.stationDateTime = :time");
        query.setParameter("rain", rain);
        query.setParameter("time", time);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        return (List<Station>) query.getResultList();
    }

    public List<Station> getCitiesWithHumidity(double humidity, LocalDateTime time){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationHumidity = :humidity AND s.stationDateTime = :time");
        query.setParameter("humidity", humidity);
        query.setParameter("time", time);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        return (List<Station>) query.getResultList();
    }

    public List<Station> getCitiesWithPressure(double pressure, LocalDateTime time){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE (s.stationVoivodshipCity = :vcity OR s.stationVoivodshipCity = :city) AND s.stationPressure = :pressure AND s.stationDateTime = :time");
        query.setParameter("pressure", pressure);
        query.setParameter("time", time);
        query.setParameter("vcity", "vcity");
        query.setParameter("city", "city");
        return (List<Station>) query.getResultList();
    }
}
