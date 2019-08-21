package api;

import data.model.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class FindStation {

    @Inject
    private GetStations getStations;

    public int get(String name) {

        List<Station> citiesList = getStations.get();

        List<Station> cityObject = citiesList.stream()
                .filter(n -> n.getStationName().equals(name))
                .collect(Collectors.toList());

        int cityId = cityObject.get(0).getStationNumber();

        return cityId;
    }
}
