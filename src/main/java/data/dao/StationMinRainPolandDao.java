package data.dao;

import data.model.StationMinRainPoland;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StationMinRainPolandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(StationMinRainPoland stationMinRainPoland) {
        entityManager.persist(stationMinRainPoland);
        return stationMinRainPoland.getStationMinRainPolandId();
    }

    public List<StationMinRainPoland> getMinRainPolands(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM StationMinRainPoland s WHERE s.stationMinRainPolandStationDateTime = :localDateTime");
        query.setParameter("localDateTime", localDateTime);
        return (List<StationMinRainPoland>) query.getResultList();
    }
}
