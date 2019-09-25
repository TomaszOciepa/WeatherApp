package data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION_MIN_WIND_POLAND")
public class StationMinWindPoland {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_MIN_WIND_POLAND_ID")
    private long stationMinWindPolandId;

    @Column(name = "STATION_MIN_WIND_POLAND_STATION_NUMBER")
    private int stationMinWindPolandStationNumber;

    @Column(name = "STATION_MIN_WIND_POLAND_STATION_NAME")
    private String stationMinWindPolandStationName;

    @Column(name = "STATION_MIN_WIND_POLAND_STATION_DATE_TIME")
    private LocalDateTime stationMinWindPolandStationDateTime;

    @Column(name = "STATION_MIN_WIND_POLAND_STATION_WIND")
    private int stationMinWindPolandStationWind;

    public StationMinWindPoland() {
    }

    public StationMinWindPoland(int stationMinWindPolandStationNumber, String stationMinWindPolandStationName, LocalDateTime stationMinWindPolandStationDateTime, int stationMinWindPolandStationWind) {
        this.stationMinWindPolandStationNumber = stationMinWindPolandStationNumber;
        this.stationMinWindPolandStationName = stationMinWindPolandStationName;
        this.stationMinWindPolandStationDateTime = stationMinWindPolandStationDateTime;
        this.stationMinWindPolandStationWind = stationMinWindPolandStationWind;
    }

    public long getStationMinWindPolandId() {
        return stationMinWindPolandId;
    }

    public void setStationMinWindPolandId(long stationMinWindPolandId) {
        this.stationMinWindPolandId = stationMinWindPolandId;
    }

    public int getStationMinWindPolandStationNumber() {
        return stationMinWindPolandStationNumber;
    }

    public void setStationMinWindPolandStationNumber(int stationMinWindPolandStationNumber) {
        this.stationMinWindPolandStationNumber = stationMinWindPolandStationNumber;
    }

    public String getStationMinWindPolandStationName() {
        return stationMinWindPolandStationName;
    }

    public void setStationMinWindPolandStationName(String stationMinWindPolandStationName) {
        this.stationMinWindPolandStationName = stationMinWindPolandStationName;
    }

    public LocalDateTime getStationMinWindPolandStationDateTime() {
        return stationMinWindPolandStationDateTime;
    }

    public void setStationMinWindPolandStationDateTime(LocalDateTime stationMinWindPolandStationDateTime) {
        this.stationMinWindPolandStationDateTime = stationMinWindPolandStationDateTime;
    }

    public int getStationMinWindPolandStationWind() {
        return stationMinWindPolandStationWind;
    }

    public void setStationMinWindPolandStationWind(int stationMinWindPolandStationWind) {
        this.stationMinWindPolandStationWind = stationMinWindPolandStationWind;
    }
}
