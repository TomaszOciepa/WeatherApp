package data.dao;

import data.model.StationMaxHumidityPoland;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StationMaxHumidityPolandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(StationMaxHumidityPoland stationMaxHumidityPoland) {
        entityManager.persist(stationMaxHumidityPoland);
        return stationMaxHumidityPoland.getStationMaxHumidityPolandId();
    }

    public List<StationMaxHumidityPoland> getMaxHumidityPolands(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM StationMaxHumidityPoland s WHERE s.stationMaxHumidityPolandStationDateTime = :localDateTime");
        query.setParameter("localDateTime", localDateTime);
        return (List<StationMaxHumidityPoland>) query.getResultList();
    }
}
