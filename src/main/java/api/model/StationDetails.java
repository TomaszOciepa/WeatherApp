package api.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationDetails {

    @JsonProperty("id_stacji")
    private String idStation;

    @JsonProperty("stacja")
    private String station;

    @JsonProperty("data_pomiaru")
    private String dateOfMeasurement;

    @JsonProperty("godzina_pomiaru")
    private String measurementTime;

    @JsonProperty("temperatura")
    private String temperature;

    @JsonProperty("predkosc_wiatru")
    private String windSpeed;

    @JsonProperty("kierunek_wiatru")
    private String windDirection;

    @JsonProperty("wilgotnosc_wzgledna")
    private String relativeHumidity;

    @JsonProperty("suma_opadu")
    private String totalRainfall;

    @JsonProperty("cisnienie")
    private String pressure;

    public StationDetails() {
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDateOfMeasurement() {
        return dateOfMeasurement;
    }

    public void setDateOfMeasurement(String dateOfMeasurement) {
        this.dateOfMeasurement = dateOfMeasurement;
    }

    public String getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(String measurementTime) {
        this.measurementTime = measurementTime;
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

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getTotalRainfall() {
        return totalRainfall;
    }

    public void setTotalRainfall(String totalRainfall) {
        this.totalRainfall = totalRainfall;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
}
