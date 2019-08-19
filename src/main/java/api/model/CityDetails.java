package api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class CityDetails {

    private int id;
    private String name;
    private LocalDate date;
    private LocalTime hour;
    private double temperature;
    private int windSpeed;
    private int windDirection;
    private double pressure;
    private double humidity;
    private BigDecimal totalRainfall;


    public CityDetails(int id, String name, LocalDate date, LocalTime hour, double temperature, int windSpeed, int windDirection, double pressure, double humidity, BigDecimal totalRainfall) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.humidity = humidity;
        this.totalRainfall = totalRainfall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public BigDecimal getTotalRainfall() {
        return totalRainfall;
    }

    public void setTotalRainfall(BigDecimal totalRainfall) {
        this.totalRainfall = totalRainfall;
    }
}
