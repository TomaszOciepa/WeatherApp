package data.dao;

import data.model.StationMinPressurePoland;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StationMinPressurePolandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(StationMinPressurePoland stationMinPressurePoland) {
        entityManager.persist(stationMinPressurePoland);
        return stationMinPressurePoland.getStationMinPressurePolandId();
    }

    public List<StationMinPressurePoland> getMinPressurePolands(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM StationMinPressurePoland s WHERE s.stationMinPressurePolandStationDateTime = :localDateTime");
        query.setParameter("localDateTime", localDateTime);
        return (List<StationMinPressurePoland>) query.getResultList();
    }
}
