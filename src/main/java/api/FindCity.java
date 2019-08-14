package api;

import api.model.City;

import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class FindCity {

    public City get(String name){

        GetCities getCities = new GetCities();
        List<City> citiesList = getCities.get();

        List<City> cityObject = citiesList.stream()
                .filter(n -> n.getName().equals(name))
                .collect(Collectors.toList());

        String cityId = cityObject.get(0).getId();
        String cityName = cityObject.get(0).getName();
        City city = new City(cityId, cityName);

        return city;
    }
}
