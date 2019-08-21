package data;

import api.JsonFileAll;
import data.dao.StationDao;
import data.model.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;

@Stateless
public class UpdateData {

    @Inject
    private GetStation getStation;
    @Inject
    private StationDao stationDao;

    public void get() {
        JsonFileAll jsonFileAll = new JsonFileAll();
        JsonArray jsonObject = jsonFileAll.getJson();

        for (int i = 0; i < jsonObject.size(); i++) {
            String id = jsonObject.getJsonObject(i).getString("id_stacji");
            Station station = getStation.get(id);
            stationDao.save(station);
        }

    }
}
