<#include "header.ftlh">
<div class="wrap">
    <div class="container">


        <div class="jumbotron jumbotron-color">
            <h1 class="display-4"><a class="link-main" href="/WeatherApp">Pogodna Apka :)</a></h1>
            <hr>
            <div class="row">
                <div class="col-sm">
                    <div class="title"><h2>${currentStationWeather.stationName}</h2></div>
                    <p>Stan na: <b>${lastUpdateString}</b></p>
                </div>
                <div class="col-sm">
                    <a class="btn btn-primary btn-lg button-green" href="weather-for-poland" role="button">inne miasto</a>
                </div>
            </div>
            <div class="weather-info">
                <div class="row">
                    <div class="col-sm border-right">
                        <p>Temperatura: <b>${currentStationWeather.stationTemperature} &#x2103</b></p>
                        <p>Ciśnienie: <b>${currentStationWeather.stationPressure?c} hPa</b></p>
                        <p>Suma opadu: <b>${currentStationWeather.stationTotalRainfall} mm</b></p>
                    </div>
                    <div class="col-sm">
                        <p>Prędkość wiatru: <b>${currentStationWeather.stationWindSpeed?c} m/s</b></p>
                        <p>Kierunek wiatru: <b>${currentStationWeather.stationWindDirection}</b></p>
                        <p>Wilgotność względna: <b>${currentStationWeather.stationHumidity} %</b></p>
                    </div>
                </div>
            </div>

        </div>


    </div>
</div>


<#include "footer.ftlh">