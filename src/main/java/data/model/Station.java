package data.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

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

    @Column(name = "STATION_DATE")
    private LocalDate stationDate;

    @Column(name = "STATION_HOUR")
    private LocalTime stationHour;

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

    public Station() {
    }

    public Station(int stationNumber, String stationName) {
        this.stationNumber = stationNumber;
        this.stationName = stationName;
    }

    public Station(int stationNumber, String stationName, LocalDate stationDate, LocalTime stationHour, double stationTemperature, int stationWindSpeed, int stationWindDirection, double stationPressure, double stationHumidity, BigDecimal stationTotalRainfall) {
        this.stationNumber = stationNumber;
        this.stationName = stationName;
        this.stationDate = stationDate;
        this.stationHour = stationHour;
        this.stationTemperature = stationTemperature;
        this.stationWindSpeed = stationWindSpeed;
        this.stationWindDirection = stationWindDirection;
        this.stationPressure = stationPressure;
        this.stationHumidity = stationHumidity;
        this.stationTotalRainfall = stationTotalRainfall;
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

    public LocalDate getStationDate() {
        return stationDate;
    }

    public void setStationDate(LocalDate stationDate) {
        this.stationDate = stationDate;
    }

    public LocalTime getStationHour() {
        return stationHour;
    }

    public void setStationHour(LocalTime stationHour) {
        this.stationHour = stationHour;
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
}
