package data.dao;

import data.model.Station;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public List<Station> getSelectedCity(String city){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationName = :city");
        query.setParameter("city", city);

        return (List<Station>) query.getResultList();
    }
    public List<String> getCitiesName(){
        final Query query = entityManager.createQuery("SELECT s.stationName FROM Station s");
        return (List<String>) query.getResultList();
    }

    public List<Double> getSumTempForPoland(){
        final Query query = entityManager.createQuery("SELECT SUM(s.stationTemperature) FROM Station s");
        return query.getResultList();
    }

    public List<Long> getCountTempForPoland(){
        final Query query = entityManager.createQuery("SELECT COUNT(s.stationTemperature) FROM Station s");
        return (List<Long>) query.getResultList();
    }

    public List<Station> lastUpdate(){
        final Query query = entityManager.createQuery("SELECT s FROM Station s ORDER BY s.stationDateTime DESC");
        return (List<Station>) query.getResultList();
    }

    public List<Double> getSumTempForCity(String city){
        final Query query = entityManager.createQuery("SELECT SUM (s.stationTemperature) FROM Station s WHERE s.stationName = :city");
        query.setParameter("city", city);
        return (List<Double>) query.getResultList();
    }

    public List<Long> getCountTempForCity(String city){
        final Query query = entityManager.createQuery("SELECT COUNT(s.stationTemperature) FROM Station s WHERE s.stationName = :city");
        query.setParameter("city", city);
        return (List<Long>) query.getResultList();
    }

    public List<Double> getSumTempYearForCity(int year, String city){
        final Query query = entityManager.createQuery("select SUM(s.stationTemperature) FROM Station s WHERE s.stationDateTime LIKE CONCAT(:year, '%') AND s.stationName = :city");
        query.setParameter("year", year);
        query.setParameter("city", city);
        return (List<Double>) query.getResultList();
    }

    public List<Long> getCountTempYearForCity(int year, String city){
        final Query query = entityManager.createQuery("select COUNT(s.stationTemperature) FROM Station s WHERE s.stationDateTime LIKE CONCAT(:year, '%') AND s.stationName = :city");
        query.setParameter("year", year);
        query.setParameter("city", city);
        return (List<Long>) query.getResultList();
    }

}
