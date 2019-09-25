package data.dao;

import data.model.StationMaxWindPoland;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StationMaxWindPolandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(StationMaxWindPoland stationMaxWindPoland) {
        entityManager.persist(stationMaxWindPoland);
        return stationMaxWindPoland.getStationMaxWindPolandId();
    }

    public List<StationMaxWindPoland> getMaxWindPoland(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM StationMaxWindPoland s WHERE s.stationMaxWindPolandStationDateTime = :localDateTime");
        query.setParameter("localDateTime", localDateTime);
        return (List<StationMaxWindPoland>) query.getResultList();
    }
}
