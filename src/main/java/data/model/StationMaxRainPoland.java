package data.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION_MAX_RAIN_POLAND")
public class StationMaxRainPoland {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_MAX_RAIN_POLAND_ID")
    private long stationMaxRainPolandId;

    @Column(name = "STATION_MAX_RAIN_POLAND_STATION_NUMBER")
    private int stationMaxRainPolandStationNumber;

    @Column(name = "STATION_MAX_RAIN_POLAND_STATION_NAME")
    private String stationMaxRainPolandStationName;

    @Column(name = "STATION_MAX_RAIN_POLAND_STATION_DATE_TIME")
    private LocalDateTime stationMaxRainPolandStationDateTime;

    @Column(name = "STATION_MAX_RAIN_POLAND_STATION_RAIN")
    private BigDecimal stationMaxRainPolandStationRain;

    public StationMaxRainPoland() {
    }

    public StationMaxRainPoland(int stationMaxRainPolandStationNumber, String stationMaxRainPolandStationName, LocalDateTime stationMaxRainPolandStationDateTime, BigDecimal stationMaxRainPolandStationRain) {
        this.stationMaxRainPolandStationNumber = stationMaxRainPolandStationNumber;
        this.stationMaxRainPolandStationName = stationMaxRainPolandStationName;
        this.stationMaxRainPolandStationDateTime = stationMaxRainPolandStationDateTime;
        this.stationMaxRainPolandStationRain = stationMaxRainPolandStationRain;
    }

    public long getStationMaxRainPolandId() {
        return stationMaxRainPolandId;
    }

    public void setStationMaxRainPolandId(long stationMaxRainPolandId) {
        this.stationMaxRainPolandId = stationMaxRainPolandId;
    }

    public int getStationMaxRainPolandStationNumber() {
        return stationMaxRainPolandStationNumber;
    }

    public void setStationMaxRainPolandStationNumber(int stationMaxRainPolandStationNumber) {
        this.stationMaxRainPolandStationNumber = stationMaxRainPolandStationNumber;
    }

    public String getStationMaxRainPolandStationName() {
        return stationMaxRainPolandStationName;
    }

    public void setStationMaxRainPolandStationName(String stationMaxRainPolandStationName) {
        this.stationMaxRainPolandStationName = stationMaxRainPolandStationName;
    }

    public LocalDateTime getStationMaxRainPolandStationDateTime() {
        return stationMaxRainPolandStationDateTime;
    }

    public void setStationMaxRainPolandStationDateTime(LocalDateTime stationMaxRainPolandStationDateTime) {
        this.stationMaxRainPolandStationDateTime = stationMaxRainPolandStationDateTime;
    }

    public BigDecimal getStationMaxRainPolandStationRain() {
        return stationMaxRainPolandStationRain;
    }

    public void setStationMaxRainPolandStationRain(BigDecimal stationMaxRainPolandStationRain) {
        this.stationMaxRainPolandStationRain = stationMaxRainPolandStationRain;
    }
}
