package api;

import data.model.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GetStations {

    @Inject
    private GetJsonAll getJsonAll;

    public List<Station> get(){

        JsonArray jsonObject1 = getJsonAll.getJson();

        List<Station> stationsList = new ArrayList<>();
        for (int i = 0; i < jsonObject1.size(); i++) {
            int id = Integer.parseInt(jsonObject1.getJsonObject(i).getString("id_stacji"));
            String name = jsonObject1.getJsonObject(i).getString("stacja");

            Station station = new Station(id, name);
            stationsList.add(station);
        }
        return stationsList;
    }
}
