package data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION_MAX_TEMP_POLAND")
public class StationMaxTempPoland {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_MAX_TEMP_POLAND_ID")
    private long stationMaxTempPolandId;

    @Column(name = "STATION_MAX_TEMP_POLAND_STATION_NUMBER")
    private int stationMaxTempPolandStationNumber;

    @Column(name = "STATION_MAX_TEMP_POLAND_STATION_NAME")
    private String stationMaxTempPolandStationName;

    @Column(name = "STATION_MAX_TEMP_POLAND_STATION_DATE_TIME")
    private LocalDateTime stationMaxTempPolandStationDateTime;

    @Column(name = "STATION_MAX_TEMP_POLAND_STATION_TEMPERATURE")
    private double stationMaxTempPolandStationTemperature;

    public StationMaxTempPoland() {
    }

    public StationMaxTempPoland(int stationMaxTempPolandStationNumber, String stationMaxTempPolandStationName, LocalDateTime stationMaxTempPolandStationDateTime, double stationMaxTempPolandStationTemperature) {
        this.stationMaxTempPolandStationNumber = stationMaxTempPolandStationNumber;
        this.stationMaxTempPolandStationName = stationMaxTempPolandStationName;
        this.stationMaxTempPolandStationDateTime = stationMaxTempPolandStationDateTime;
        this.stationMaxTempPolandStationTemperature = stationMaxTempPolandStationTemperature;
    }


    public long getStationMaxTempPolandId() {
        return stationMaxTempPolandId;
    }

    public void setStationMaxTempPolandId(long stationMaxTempPolandId) {
        this.stationMaxTempPolandId = stationMaxTempPolandId;
    }

    public int getStationMaxTempPolandStationNumber() {
        return stationMaxTempPolandStationNumber;
    }

    public void setStationMaxTempPolandStationNumber(int stationMaxTempPolandStationNumber) {
        this.stationMaxTempPolandStationNumber = stationMaxTempPolandStationNumber;
    }

    public String getStationMaxTempPolandStationName() {
        return stationMaxTempPolandStationName;
    }

    public void setStationMaxTempPolandStationName(String stationMaxTempPolandStationName) {
        this.stationMaxTempPolandStationName = stationMaxTempPolandStationName;
    }

    public LocalDateTime getStationMaxTempPolandStationDateTime() {
        return stationMaxTempPolandStationDateTime;
    }

    public void setStationMaxTempPolandStationDateTime(LocalDateTime stationMaxTempPolandStationDateTime) {
        this.stationMaxTempPolandStationDateTime = stationMaxTempPolandStationDateTime;
    }

    public double getStationMaxTempPolandStationTemperature() {
        return stationMaxTempPolandStationTemperature;
    }

    public void setStationMaxTempPolandStationTemperature(double stationMaxTempPolandStationTemperature) {
        this.stationMaxTempPolandStationTemperature = stationMaxTempPolandStationTemperature;
    }
}
