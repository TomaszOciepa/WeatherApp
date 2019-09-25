package data.dao;

import data.model.StationMinHumidityPoland;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StationMinHumidityPolandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(StationMinHumidityPoland stationMinHumidityPoland) {
        entityManager.persist(stationMinHumidityPoland);
        return stationMinHumidityPoland.getStationMinHumidityPolandId();
    }

    public List<StationMinHumidityPoland> getMinHumidityPolands(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM StationMinHumidityPoland s WHERE s.stationMinHumidityPolandStationDateTime = :localDateTime");
        query.setParameter("localDateTime", localDateTime);
        return (List<StationMinHumidityPoland>) query.getResultList();
    }
}
