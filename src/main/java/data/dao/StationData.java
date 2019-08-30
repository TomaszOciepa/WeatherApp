package data.dao;

import data.model.Station;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


public class StationData {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Station> lastUpdate() {
        final Query query = entityManager.createQuery("SELECT s FROM Station s ORDER BY s.stationDateTime DESC");
        return (List<Station>) query.getResultList();
    }

    public List<Double> getSumTempForPoland() {
        final Query query = entityManager.createQuery("SELECT SUM(s.stationTemperature) FROM Station s");
        return query.getResultList();
    }
}
