package data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION_MAX_PRESSURE_POLAND")
public class StationMaxPressurePoland {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_MAX_PRESSURE_POLAND_ID")
    private long stationMaxPressurePolandId;

    @Column(name = "STATION_MAX_PRESSURE_POLAND_STATION_NUMBER")
    private int stationMaxPressurePolandStationNumber;

    @Column(name = "STATION_MAX_PRESSURE_POLAND_STATION_NAME")
    private String stationMaxPressurePolandStationName;

    @Column(name = "STATION_MAX_PRESSURE_POLAND_STATION_DATE_TIME")
    private LocalDateTime stationMaxPressurePolandStationDateTime;

    @Column(name = "STATION_MAX_PRESSURE_POLAND_STATION_PRESSURE")
    private double stationMaxPressurePolandStationPressure;

    public StationMaxPressurePoland() {
    }

    public StationMaxPressurePoland(int stationMaxPressurePolandStationNumber, String stationMaxPressurePolandStationName, LocalDateTime stationMaxPressurePolandStationDateTime, double stationMaxPressurePolandStationPressure) {
        this.stationMaxPressurePolandStationNumber = stationMaxPressurePolandStationNumber;
        this.stationMaxPressurePolandStationName = stationMaxPressurePolandStationName;
        this.stationMaxPressurePolandStationDateTime = stationMaxPressurePolandStationDateTime;
        this.stationMaxPressurePolandStationPressure = stationMaxPressurePolandStationPressure;
    }

    public long getStationMaxPressurePolandId() {
        return stationMaxPressurePolandId;
    }

    public void setStationMaxPressurePolandId(long stationMaxPressurePolandId) {
        this.stationMaxPressurePolandId = stationMaxPressurePolandId;
    }

    public int getStationMaxPressurePolandStationNumber() {
        return stationMaxPressurePolandStationNumber;
    }

    public void setStationMaxPressurePolandStationNumber(int stationMaxPressurePolandStationNumber) {
        this.stationMaxPressurePolandStationNumber = stationMaxPressurePolandStationNumber;
    }

    public String getStationMaxPressurePolandStationName() {
        return stationMaxPressurePolandStationName;
    }

    public void setStationMaxPressurePolandStationName(String stationMaxPressurePolandStationName) {
        this.stationMaxPressurePolandStationName = stationMaxPressurePolandStationName;
    }

    public LocalDateTime getStationMaxPressurePolandStationDateTime() {
        return stationMaxPressurePolandStationDateTime;
    }

    public void setStationMaxPressurePolandStationDateTime(LocalDateTime stationMaxPressurePolandStationDateTime) {
        this.stationMaxPressurePolandStationDateTime = stationMaxPressurePolandStationDateTime;
    }

    public double getStationMaxPressurePolandStationPressure() {
        return stationMaxPressurePolandStationPressure;
    }

    public void setStationMaxPressurePolandStationPressure(double stationMaxPressurePolandStationPressure) {
        this.stationMaxPressurePolandStationPressure = stationMaxPressurePolandStationPressure;
    }
}

