package data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION_MIN_HUMIDITY_POLAND")
public class StationMinHumidityPoland {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_MIN_HUMIDITY_POLAND_ID")
    private long stationMinHumidityPolandId;

    @Column(name = "STATION_MIN_HUMIDITY_POLAND_STATION_NUMBER")
    private int stationMinHumidityPolandStationNumber;

    @Column(name = "STATION_MIN_HUMIDITY_POLAND_STATION_NAME")
    private String stationMinHumidityPolandStationName;

    @Column(name = "STATION_MIN_HUMIDITY_POLAND_STATION_DATE_TIME")
    private LocalDateTime stationMinHumidityPolandStationDateTime;

    @Column(name = "STATION_MIN_HUMIDITY_POLAND_STATION_HUMIDITY")
    private double stationMinHumidityPolandStationHumidity;

    public StationMinHumidityPoland() {
    }

    public StationMinHumidityPoland(int stationMinHumidityPolandStationNumber, String stationMinHumidityPolandStationName, LocalDateTime stationMinHumidityPolandStationDateTime, double stationMinHumidityPolandStationHumidity) {
        this.stationMinHumidityPolandStationNumber = stationMinHumidityPolandStationNumber;
        this.stationMinHumidityPolandStationName = stationMinHumidityPolandStationName;
        this.stationMinHumidityPolandStationDateTime = stationMinHumidityPolandStationDateTime;
        this.stationMinHumidityPolandStationHumidity = stationMinHumidityPolandStationHumidity;
    }

    public long getStationMinHumidityPolandId() {
        return stationMinHumidityPolandId;
    }

    public void setStationMinHumidityPolandId(long stationMinHumidityPolandId) {
        this.stationMinHumidityPolandId = stationMinHumidityPolandId;
    }

    public int getStationMinHumidityPolandStationNumber() {
        return stationMinHumidityPolandStationNumber;
    }

    public void setStationMinHumidityPolandStationNumber(int stationMinHumidityPolandStationNumber) {
        this.stationMinHumidityPolandStationNumber = stationMinHumidityPolandStationNumber;
    }

    public String getStationMinHumidityPolandStationName() {
        return stationMinHumidityPolandStationName;
    }

    public void setStationMinHumidityPolandStationName(String stationMinHumidityPolandStationName) {
        this.stationMinHumidityPolandStationName = stationMinHumidityPolandStationName;
    }

    public LocalDateTime getStationMinHumidityPolandStationDateTime() {
        return stationMinHumidityPolandStationDateTime;
    }

    public void setStationMinHumidityPolandStationDateTime(LocalDateTime stationMinHumidityPolandStationDateTime) {
        this.stationMinHumidityPolandStationDateTime = stationMinHumidityPolandStationDateTime;
    }

    public double getStationMinHumidityPolandStationHumidity() {
        return stationMinHumidityPolandStationHumidity;
    }

    public void setStationMinHumidityPolandStationHumidity(double stationMinHumidityPolandStationHumidity) {
        this.stationMinHumidityPolandStationHumidity = stationMinHumidityPolandStationHumidity;
    }
}
