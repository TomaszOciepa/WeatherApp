package data;

import api.GetStation;
import api.GetJsonAll;
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
    @Inject
    private GetJsonAll getJsonAll;

    public void save() {
        JsonArray jsonObject = getJsonAll.getJson();

        for (int i = 0; i < jsonObject.size(); i++) {
            int id = Integer.parseInt(jsonObject.getJsonObject(i).getString("id_stacji"));
            Station station = getStation.get(id);
            stationDao.save(station);
        }

    }
}
