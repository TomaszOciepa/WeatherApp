package data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION_MIN_PRESSURE_POLAND")
public class StationMinPressurePoland {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_MIN_PRESSURE_POLAND_ID")
    private long stationMinPressurePolandId;

    @Column(name = "STATION_MIN_PRESSURE_POLAND_STATION_NUMBER")
    private int stationMinPressurePolandStationNumber;

    @Column(name = "STATION_MIN_PRESSURE_POLAND_STATION_NAME")
    private String stationMinPressurePolandStationName;

    @Column(name = "STATION_MIN_PRESSURE_POLAND_STATION_DATE_TIME")
    private LocalDateTime stationMinPressurePolandStationDateTime;

    @Column(name = "STATION_MIN_PRESSURE_POLAND_STATION_PRESSURE")
    private double stationMinPressurePolandStationPressure;

    public StationMinPressurePoland() {
    }

    public StationMinPressurePoland(int stationMinPressurePolandStationNumber, String stationMinPressurePolandStationName, LocalDateTime stationMinPressurePolandStationDateTime, double stationMinPressurePolandStationPressure) {
        this.stationMinPressurePolandStationNumber = stationMinPressurePolandStationNumber;
        this.stationMinPressurePolandStationName = stationMinPressurePolandStationName;
        this.stationMinPressurePolandStationDateTime = stationMinPressurePolandStationDateTime;
        this.stationMinPressurePolandStationPressure = stationMinPressurePolandStationPressure;
    }

    public long getStationMinPressurePolandId() {
        return stationMinPressurePolandId;
    }

    public void setStationMinPressurePolandId(long stationMinPressurePolandId) {
        this.stationMinPressurePolandId = stationMinPressurePolandId;
    }

    public int getStationMinPressurePolandStationNumber() {
        return stationMinPressurePolandStationNumber;
    }

    public void setStationMinPressurePolandStationNumber(int stationMinPressurePolandStationNumber) {
        this.stationMinPressurePolandStationNumber = stationMinPressurePolandStationNumber;
    }

    public String getStationMinPressurePolandStationName() {
        return stationMinPressurePolandStationName;
    }

    public void setStationMinPressurePolandStationName(String stationMinPressurePolandStationName) {
        this.stationMinPressurePolandStationName = stationMinPressurePolandStationName;
    }

    public LocalDateTime getStationMinPressurePolandStationDateTime() {
        return stationMinPressurePolandStationDateTime;
    }

    public void setStationMinPressurePolandStationDateTime(LocalDateTime stationMinPressurePolandStationDateTime) {
        this.stationMinPressurePolandStationDateTime = stationMinPressurePolandStationDateTime;
    }

    public double getStationMinPressurePolandStationPressure() {
        return stationMinPressurePolandStationPressure;
    }

    public void setStationMinPressurePolandStationPressure(double stationMinPressurePolandStationPressure) {
        this.stationMinPressurePolandStationPressure = stationMinPressurePolandStationPressure;
    }
}
