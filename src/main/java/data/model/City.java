package data.model;

import javax.persistence.*;

@Entity
@Table(name = "CITY")
public class City {

    @Id
    @Column(name = "CITY_ID")
    private int cityId;

    @Column(name = "CITY_NAME")
    private String cityName;

    public City() {
    }

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
