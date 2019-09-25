package data.dao;

import data.model.StationMinWindPoland;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StationMinWindPolandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(StationMinWindPoland stationMinWindPoland) {
        entityManager.persist(stationMinWindPoland);
        return stationMinWindPoland.getStationMinWindPolandId();
    }

    public List<StationMinWindPoland> getMinWindPoland(LocalDateTime localDateTime){
        final Query query = entityManager.createQuery("SELECT s FROM StationMinWindPoland s WHERE s.stationMinWindPolandStationDateTime = :localDateTime");
        query.setParameter("localDateTime", localDateTime);
        return (List<StationMinWindPoland>) query.getResultList();
    }
}
