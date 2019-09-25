package data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION_MAX_WIND_POLAND")
public class StationMaxWindPoland {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_MAX_WIND_POLAND_ID")
    private long stationMaxWindPolandId;

    @Column(name = "STATION_MAX_WIND_POLAND_STATION_NUMBER")
    private int stationMaxWindPolandStationNumber;

    @Column(name = "STATION_MAX_WIND_POLAND_STATION_NAME")
    private String stationMaxWindPolandStationName;

    @Column(name = "STATION_MAX_WIND_POLAND_STATION_DATE_TIME")
    private LocalDateTime stationMaxWindPolandStationDateTime;

    @Column(name = "STATION_MAX_WIND_POLAND_STATION_WIND")
    private int stationMaxWindPolandStationWind;

    public StationMaxWindPoland() {
    }

    public StationMaxWindPoland(int stationMaxWindPolandStationNumber, String stationMaxWindPolandStationName, LocalDateTime stationMaxWindPolandStationDateTime, int stationMaxWindPolandStationWind) {
        this.stationMaxWindPolandStationNumber = stationMaxWindPolandStationNumber;
        this.stationMaxWindPolandStationName = stationMaxWindPolandStationName;
        this.stationMaxWindPolandStationDateTime = stationMaxWindPolandStationDateTime;
        this.stationMaxWindPolandStationWind = stationMaxWindPolandStationWind;
    }

    public long getStationMaxWindPolandId() {
        return stationMaxWindPolandId;
    }

    public void setStationMaxWindPolandId(long stationMaxWindPolandId) {
        this.stationMaxWindPolandId = stationMaxWindPolandId;
    }

    public int getStationMaxWindPolandStationNumber() {
        return stationMaxWindPolandStationNumber;
    }

    public void setStationMaxWindPolandStationNumber(int stationMaxWindPolandStationNumber) {
        this.stationMaxWindPolandStationNumber = stationMaxWindPolandStationNumber;
    }

    public String getStationMaxWindPolandStationName() {
        return stationMaxWindPolandStationName;
    }

    public void setStationMaxWindPolandStationName(String stationMaxWindPolandStationName) {
        this.stationMaxWindPolandStationName = stationMaxWindPolandStationName;
    }

    public LocalDateTime getStationMaxWindPolandStationDateTime() {
        return stationMaxWindPolandStationDateTime;
    }

    public void setStationMaxWindPolandStationDateTime(LocalDateTime stationMaxWindPolandStationDateTime) {
        this.stationMaxWindPolandStationDateTime = stationMaxWindPolandStationDateTime;
    }

    public int getStationMaxWindPolandStationWind() {
        return stationMaxWindPolandStationWind;
    }

    public void setStationMaxWindPolandStationWind(int stationMaxWindPolandStationWind) {
        this.stationMaxWindPolandStationWind = stationMaxWindPolandStationWind;
    }
}
