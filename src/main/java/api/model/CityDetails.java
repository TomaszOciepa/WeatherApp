package api.model;

public class CityDetails {

    private String id;
    private String name;
    private String date;
    private String temperature;

    public CityDetails(String id, String name, String date, String temperature) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.temperature = temperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
