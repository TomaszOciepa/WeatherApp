package data.dao;

import data.model.StationMaxPressurePoland;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StationMaxPressurePolandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(StationMaxPressurePoland stationMaxPressurePoland) {
        entityManager.persist(stationMaxPressurePoland);
        return stationMaxPressurePoland.getStationMaxPressurePolandId();
    }

    public List<StationMaxPressurePoland> getMaxPressurePolands(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM StationMaxPressurePoland s WHERE s.stationMaxPressurePolandStationDateTime = :localDateTime");
        query.setParameter("localDateTime", localDateTime);
        return (List<StationMaxPressurePoland>) query.getResultList();
    }
}
