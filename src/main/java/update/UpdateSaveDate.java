package update;

import api.GetStation;
import api.GetJsonAll;
import data.dao.StationDao;
import data.model.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;

@Stateless
public class UpdateSaveDate {

    @Inject
    private GetStation getStation;
    @Inject
    private StationDao stationDao;
    @Inject
    private GetJsonAll getJsonAll;
    @Inject
    private UpdateSaveMaxTempPoland updateSaveMaxTempPoland;
    @Inject
    private UpdateSaveMinTempPoland updateSaveMinTempPoland;
    @Inject
    private UpdateSaveMaxWindPoland updateSaveMaxWindPoland;
    @Inject
    private UpdateSaveMinWindPoland updateSaveMinWindPoland;
    @Inject
    private UpdateSaveMaxRainPoland updateSaveMaxRainPoland;
    @Inject
    private UpdateSaveMinRainPoland updateSaveMinRainPoland;
    @Inject
    private UpdateSaveMaxHumidityPoland updateSaveMaxHumidityPoland;
    @Inject
    private UpdateSaveMinHumidityPoland updateSaveMinHumidityPoland;

    public void save() {
        JsonArray jsonObject = getJsonAll.getJson();

        for (int i = 0; i < jsonObject.size(); i++) {
            int id = Integer.parseInt(jsonObject.getJsonObject(i).getString("id_stacji"));
            Station station = getStation.get(id);
            stationDao.save(station);
        }
        updateSaveMaxTempPoland.save();
        updateSaveMinTempPoland.save();
        updateSaveMaxWindPoland.save();
        updateSaveMinWindPoland.save();
        updateSaveMaxRainPoland.save();
        updateSaveMinRainPoland.save();
        updateSaveMaxHumidityPoland.save();
        updateSaveMinHumidityPoland.save();

    }
}
