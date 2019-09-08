package data.model;

import javax.ejb.Timeout;
import javax.inject.Named;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_ID")
    private long stationId;

    @Column(name = "STATION_NUMBER")
    private int stationNumber;

    @Column(name = "STATION_NAME")
    private String stationName;

    @Column(name = "STATION_DATE_TIME")
    private LocalDateTime stationDateTime;

    @Column(name = "STATION_TEMPERATURE")
    private double stationTemperature;

    @Column(name = "STATION_WIND_SPEED")
    private int stationWindSpeed;

    @Column(name = "STATION_WIND_DIRECTION")
    private int stationWindDirection;

    @Column(name = "STATION_PRESSURE")
    private double stationPressure;

    @Column(name = "STATION_HUMIDITY")
    private double stationHumidity;

    @Column(name = "STATION_TOTAL_RAINFALL")
    private BigDecimal stationTotalRainfall;

    @Column(name = "STATION_VOIVODSHIP_CITY")
    private String stationVoivodshipCity;

    public Station() {
    }

    public Station(LocalDateTime stationDateTime, double stationTemperature) {
        this.stationDateTime = stationDateTime;
        this.stationTemperature = stationTemperature;
    }

    public Station(int stationNumber, String stationName) {
        this.stationNumber = stationNumber;
        this.stationName = stationName;
    }

    public Station(int stationNumber, String stationName, LocalDateTime stationDateTime, double stationTemperature, int stationWindSpeed, int stationWindDirection, double stationPressure, double stationHumidity, BigDecimal stationTotalRainfall, String stationVoivodshipCity) {
        this.stationNumber = stationNumber;
        this.stationName = stationName;
        this.stationDateTime = stationDateTime;
        this.stationTemperature = stationTemperature;
        this.stationWindSpeed = stationWindSpeed;
        this.stationWindDirection = stationWindDirection;
        this.stationPressure = stationPressure;
        this.stationHumidity = stationHumidity;
        this.stationTotalRainfall = stationTotalRainfall;
        this.stationVoivodshipCity = stationVoivodshipCity;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int stationNumber) {
        this.stationNumber = stationNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public LocalDateTime getStationDateTime() {
        return stationDateTime;
    }

    public void setStationDateTime(LocalDateTime stationDateTime) {
        this.stationDateTime = stationDateTime;
    }

    public double getStationTemperature() {
        return stationTemperature;
    }

    public void setStationTemperature(double stationTemperature) {
        this.stationTemperature = stationTemperature;
    }

    public int getStationWindSpeed() {
        return stationWindSpeed;
    }

    public void setStationWindSpeed(int stationWindSpeed) {
        this.stationWindSpeed = stationWindSpeed;
    }

    public int getStationWindDirection() {
        return stationWindDirection;
    }

    public void setStationWindDirection(int stationWindDirection) {
        this.stationWindDirection = stationWindDirection;
    }

    public double getStationPressure() {
        return stationPressure;
    }

    public void setStationPressure(double stationPressure) {
        this.stationPressure = stationPressure;
    }

    public double getStationHumidity() {
        return stationHumidity;
    }

    public void setStationHumidity(double stationHumidity) {
        this.stationHumidity = stationHumidity;
    }

    public BigDecimal getStationTotalRainfall() {
        return stationTotalRainfall;
    }

    public void setStationTotalRainfall(BigDecimal stationTotalRainfall) {
        this.stationTotalRainfall = stationTotalRainfall;
    }

    public String getStationVoivodshipCity() {
        return stationVoivodshipCity;
    }

    public void setStationVoivodshipCity(String stationVoivodshipCity) {
        this.stationVoivodshipCity = stationVoivodshipCity;
    }
}
