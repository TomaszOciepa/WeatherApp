package data.dao;

import data.model.StationMaxTempPoland;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StationMaxTempPolandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(StationMaxTempPoland stationMaxTempPoland) {
        entityManager.persist(stationMaxTempPoland);
        return stationMaxTempPoland.getStationMaxTempPolandId();
    }

    public List<StationMaxTempPoland> getMaxTempPolands(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM StationMaxTempPoland s WHERE s.stationMaxTempPolandStationDateTime = :localDateTime");
        query.setParameter("localDateTime", localDateTime);
        return (List<StationMaxTempPoland>) query.getResultList();
    }
}
