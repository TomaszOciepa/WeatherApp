package data.dao;

import data.model.StationMinTempPoland;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StationMinTempPolandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(StationMinTempPoland stationMinTempPoland) {
        entityManager.persist(stationMinTempPoland);
        return stationMinTempPoland.getStationMinTempPolandId();
    }

    public List<StationMinTempPoland> getMinTempPolands(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM StationMinTempPoland s WHERE s.stationMinTempPolandStationDateTime = :localDateTime");
        query.setParameter("localDateTime", localDateTime);
        return (List<StationMinTempPoland>) query.getResultList();
    }
}
