package api.model;

public class CityDetails {

    private String id;
    private String name;
    private String date;
    private String hour;
    private String temperature;
    private String windSpeed;
    private String windDirection;
    private String pressure;
    private String humidity;
    private String totalRainfall;


    public CityDetails(String id, String name, String date, String hour, String temperature, String windSpeed, String windDirection, String pressure, String humidity, String totalRainfall) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.humidity = humidity;
        this.totalRainfall = totalRainfall;
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

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTotalRainfall() {
        return totalRainfall;
    }

    public void setTotalRainfall(String totalRainfall) {
        this.totalRainfall = totalRainfall;
    }
}
