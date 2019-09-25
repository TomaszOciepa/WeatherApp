package data.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATION_MIN_RAIN_POLAND")
public class StationMinRainPoland {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATION_MIN_RAIN_POLAND_ID")
    private long stationMinRainPolandId;

    @Column(name = "STATION_MIN_RAIN_POLAND_STATION_NUMBER")
    private int stationMinRainPolandStationNumber;

    @Column(name = "STATION_MIN_RAIN_POLAND_STATION_NAME")
    private String stationMinRainPolandStationName;

    @Column(name = "STATION_MIN_RAIN_POLAND_STATION_DATE_TIME")
    private LocalDateTime stationMinRainPolandStationDateTime;

    @Column(name = "STATION_MIN_RAIN_POLAND_STATION_RAIN")
    private BigDecimal stationMinRainPolandStationRain;

    public StationMinRainPoland() {
    }

    public StationMinRainPoland(int stationMinRainPolandStationNumber, String stationMinRainPolandStationName, LocalDateTime stationMinRainPolandStationDateTime, BigDecimal stationMinRainPolandStationRain) {
        this.stationMinRainPolandStationNumber = stationMinRainPolandStationNumber;
        this.stationMinRainPolandStationName = stationMinRainPolandStationName;
        this.stationMinRainPolandStationDateTime = stationMinRainPolandStationDateTime;
        this.stationMinRainPolandStationRain = stationMinRainPolandStationRain;
    }

    public long getStationMinRainPolandId() {
        return stationMinRainPolandId;
    }

    public void setStationMinRainPolandId(long stationMinRainPolandId) {
        this.stationMinRainPolandId = stationMinRainPolandId;
    }

    public int getStationMinRainPolandStationNumber() {
        return stationMinRainPolandStationNumber;
    }

    public void setStationMinRainPolandStationNumber(int stationMinRainPolandStationNumber) {
        this.stationMinRainPolandStationNumber = stationMinRainPolandStationNumber;
    }

    public String getStationMinRainPolandStationName() {
        return stationMinRainPolandStationName;
    }

    public void setStationMinRainPolandStationName(String stationMinRainPolandStationName) {
        this.stationMinRainPolandStationName = stationMinRainPolandStationName;
    }

    public LocalDateTime getStationMinRainPolandStationDateTime() {
        return stationMinRainPolandStationDateTime;
    }

    public void setStationMinRainPolandStationDateTime(LocalDateTime stationMinRainPolandStationDateTime) {
        this.stationMinRainPolandStationDateTime = stationMinRainPolandStationDateTime;
    }

    public BigDecimal getStationMinRainPolandStationRain() {
        return stationMinRainPolandStationRain;
    }

    public void setStationMinRainPolandStationRain(BigDecimal stationMinRainPolandStationRain) {
        this.stationMinRainPolandStationRain = stationMinRainPolandStationRain;
    }
}
