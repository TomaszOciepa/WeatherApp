package data.dao;

import data.model.StationMaxRainPoland;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StationMaxRainPolandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(StationMaxRainPoland stationMaxRainPoland) {
        entityManager.persist(stationMaxRainPoland);
        return stationMaxRainPoland.getStationMaxRainPolandId();
    }

    public List<StationMaxRainPoland> getMaxRainPolands(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM StationMaxRainPoland s WHERE s.stationMaxRainPolandStationDateTime = :localDateTime");
        query.setParameter("localDateTime", localDateTime);
        return (List<StationMaxRainPoland>) query.getResultList();
    }

}
