package data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION_MAX_HUMIDITY_POLAND")
public class StationMaxHumidityPoland {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_MAX_HUMIDITY_POLAND_ID")
    private long stationMaxHumidityPolandId;

    @Column(name = "STATION_MAX_HUMIDITY_POLAND_STATION_NUMBER")
    private int stationMaxHumidityPolandStationNumber;

    @Column(name = "STATION_MAX_HUMIDITY_POLAND_STATION_NAME")
    private String stationMaxHumidityPolandStationName;

    @Column(name = "STATION_MAX_HUMIDITY_POLAND_STATION_DATE_TIME")
    private LocalDateTime stationMaxHumidityPolandStationDateTime;

    @Column(name = "STATION_MAX_HUMIDITY_POLAND_STATION_HUMIDITY")
    private double stationMaxHumidityPolandStationHumidity;

    public StationMaxHumidityPoland() {
    }

    public StationMaxHumidityPoland(int stationMaxHumidityPolandStationNumber, String stationMaxHumidityPolandStationName, LocalDateTime stationMaxHumidityPolandStationDateTime, double stationMaxHumidityPolandStationHumidity) {
        this.stationMaxHumidityPolandStationNumber = stationMaxHumidityPolandStationNumber;
        this.stationMaxHumidityPolandStationName = stationMaxHumidityPolandStationName;
        this.stationMaxHumidityPolandStationDateTime = stationMaxHumidityPolandStationDateTime;
        this.stationMaxHumidityPolandStationHumidity = stationMaxHumidityPolandStationHumidity;
    }

    public long getStationMaxHumidityPolandId() {
        return stationMaxHumidityPolandId;
    }

    public void setStationMaxHumidityPolandId(long stationMaxHumidityPolandId) {
        this.stationMaxHumidityPolandId = stationMaxHumidityPolandId;
    }

    public int getStationMaxHumidityPolandStationNumber() {
        return stationMaxHumidityPolandStationNumber;
    }

    public void setStationMaxHumidityPolandStationNumber(int stationMaxHumidityPolandStationNumber) {
        this.stationMaxHumidityPolandStationNumber = stationMaxHumidityPolandStationNumber;
    }

    public String getStationMaxHumidityPolandStationName() {
        return stationMaxHumidityPolandStationName;
    }

    public void setStationMaxHumidityPolandStationName(String stationMaxHumidityPolandStationName) {
        this.stationMaxHumidityPolandStationName = stationMaxHumidityPolandStationName;
    }

    public LocalDateTime getStationMaxHumidityPolandStationDateTime() {
        return stationMaxHumidityPolandStationDateTime;
    }

    public void setStationMaxHumidityPolandStationDateTime(LocalDateTime stationMaxHumidityPolandStationDateTime) {
        this.stationMaxHumidityPolandStationDateTime = stationMaxHumidityPolandStationDateTime;
    }

    public double getStationMaxHumidityPolandStationHumidity() {
        return stationMaxHumidityPolandStationHumidity;
    }

    public void setStationMaxHumidityPolandStationHumidity(double stationMaxHumidityPolandStationHumidity) {
        this.stationMaxHumidityPolandStationHumidity = stationMaxHumidityPolandStationHumidity;
    }
}
