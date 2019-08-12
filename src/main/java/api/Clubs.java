package api;

import java.time.LocalDate;

public class Clubs {

    private String name;
    private String city;
    private int winTitle;
    private LocalDate date;

    @SuppressWarnings("unused")
    public Clubs() {
    }

    public Clubs(String name, String city, int winTitle, LocalDate date) {
        this.name = name;
        this.city = city;
        this.winTitle = winTitle;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getWinTitle() {
        return winTitle;
    }

    public void setWinTitle(int winTitle) {
        this.winTitle = winTitle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
