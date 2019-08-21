package data.dao;

import data.model.City;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class CityDao {

    @PersistenceContext
    private EntityManager entityManager;

    public int save(City city){
        entityManager.persist(city);
        return city.getCityId();
    }

    public City update(City city) {
        return entityManager.merge(city);
    }

    public void delete(int id) {
        final City city = entityManager.find(City.class, id);
        if (city != null) {
            entityManager.remove(city);
        }
    }

    public City findById(int id) {
        return entityManager.find(City.class, id);
    }

    public List<City> findAll() {
        final Query query = entityManager.createQuery("SELECT c FROM City c");

        return (List<City>) query.getResultList();
    }
}
