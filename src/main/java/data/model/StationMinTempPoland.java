package data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION_MIN_TEMP_POLAND")
public class StationMinTempPoland {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_MIN_TEMP_POLAND_ID")
    private long stationMinTempPolandId;

    @Column(name = "STATION_MIN_TEMP_POLAND_STATION_NUMBER")
    private int stationMinTempPolandStationNumber;

    @Column(name = "STATION_MIN_TEMP_POLAND_STATION_NAME")
    private String stationMinTempPolandStationName;

    @Column(name = "STATION_MIN_TEMP_POLAND_STATION_DATE_TIME")
    private LocalDateTime stationMinTempPolandStationDateTime;

    @Column(name = "STATION_MIN_TEMP_POLAND_STATION_TEMPERATURE")
    private double stationMinTempPolandStationTemperature;

    public StationMinTempPoland() {
    }

    public StationMinTempPoland(int stationMinTempPolandStationNumber, String stationMinTempPolandStationName, LocalDateTime stationMinTempPolandStationDateTime, double stationMinTempPolandStationTemperature) {
        this.stationMinTempPolandStationNumber = stationMinTempPolandStationNumber;
        this.stationMinTempPolandStationName = stationMinTempPolandStationName;
        this.stationMinTempPolandStationDateTime = stationMinTempPolandStationDateTime;
        this.stationMinTempPolandStationTemperature = stationMinTempPolandStationTemperature;
    }

    public long getStationMinTempPolandId() {
        return stationMinTempPolandId;
    }

    public void setStationMinTempPolandId(long stationMinTempPolandId) {
        this.stationMinTempPolandId = stationMinTempPolandId;
    }

    public int getStationMinTempPolandStationNumber() {
        return stationMinTempPolandStationNumber;
    }

    public void setStationMinTempPolandStationNumber(int stationMinTempPolandStationNumber) {
        this.stationMinTempPolandStationNumber = stationMinTempPolandStationNumber;
    }

    public String getStationMinTempPolandStationName() {
        return stationMinTempPolandStationName;
    }

    public void setStationMinTempPolandStationName(String stationMinTempPolandStationName) {
        this.stationMinTempPolandStationName = stationMinTempPolandStationName;
    }

    public LocalDateTime getStationMinTempPolandStationDateTime() {
        return stationMinTempPolandStationDateTime;
    }

    public void setStationMinTempPolandStationDateTime(LocalDateTime stationMinTempPolandStationDateTime) {
        this.stationMinTempPolandStationDateTime = stationMinTempPolandStationDateTime;
    }

    public double getStationMinTempPolandStationTemperature() {
        return stationMinTempPolandStationTemperature;
    }

    public void setStationMinTempPolandStationTemperature(double stationMinTempPolandStationTemperature) {
        this.stationMinTempPolandStationTemperature = stationMinTempPolandStationTemperature;
    }
}
