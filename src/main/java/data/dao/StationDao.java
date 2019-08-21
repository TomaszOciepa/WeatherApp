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

    public long save(Station station){
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
}
