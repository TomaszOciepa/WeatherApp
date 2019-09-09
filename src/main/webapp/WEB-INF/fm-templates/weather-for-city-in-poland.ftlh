<#include "header.ftlh">
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<div class="wrap">
    <div class="container">


        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h1 class="display-4"><a class="link-main" href="/WeatherApp">Pogodna Apka :)</a></h1>
                </div><div class="col-sm">
                    <a class="btn btn-primary btn-lg button-green" href="weather-for-poland" role="button">inne miasto</a>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-sm">
                    <div class="title"><h2>${currentStationWeather.stationName}</h2></div>
                    <p>Stan na: <b>${lastUpdateDateTimeString}</b></p>
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
            <hr>

           <h3>Wykres dla: <b>${lastUpdateDateString}</b></h3>
            <p><a href="weather-for-city-in-poland-last-update-month">[Zobacz cały miesiąc]</a></p>
            <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="pills-temp-tab" data-toggle="pill" href="#pills-temp" role="tab" aria-controls="pills-temp" aria-selected="true">Temperatura</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-windSpeed-tab" data-toggle="pill" href="#pills-windSpeed" role="tab" aria-controls="pills-windSpeed" aria-selected="false">Wiatr</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-rainfall-tab" data-toggle="pill" href="#pills-rainfall" role="tab" aria-controls="pills-rainfall" aria-selected="false">Suma opadów</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-humidity-tab" data-toggle="pill" href="#pills-humidity" role="tab" aria-controls="pills-humidity" aria-selected="false">Wilgotność</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-pressure-tab" data-toggle="pill" href="#pills-pressure" role="tab" aria-controls="pills-pressure" aria-selected="false">Ciśnienie</a>
                </li>
            </ul>
            <div class="tab-content" id="pills-tabContent">
                <div class="tab-pane fade show active" id="pills-temp" role="tabpanel" aria-labelledby="pills-temp-tab">
                    <canvas id="TempChart" width="400" height="200" aria-label="Hello ARIA World" role="img"></canvas>
                </div>
                <div class="tab-pane fade" id="pills-windSpeed" role="tabpanel" aria-labelledby="pills-windSpeed-tab">
                    <canvas id="WindSpeedChart" width="400" height="200" aria-label="Hello ARIA World" role="img"></canvas>
                </div>
                <div class="tab-pane fade" id="pills-rainfall" role="tabpanel" aria-labelledby="pills-rainfall-tab">
                    <canvas id="TotalRainFallChart" width="400" height="200" aria-label="Hello ARIA World" role="img"></canvas>
                </div>
                <div class="tab-pane fade" id="pills-humidity" role="tabpanel" aria-labelledby="pills-humidity-tab">
                    <canvas id="humidityChart" width="400" height="200" aria-label="Hello ARIA World" role="img"></canvas>
                </div>
                <div class="tab-pane fade" id="pills-pressure" role="tabpanel" aria-labelledby="pills-pressure-tab">
                    <canvas id="pressureChart" width="400" height="200" aria-label="Hello ARIA World" role="img"></canvas>
                </div>
            </div>

        </div>
    </div>
</div>

<#include "ScriptChartPolandCity.ftlh">
<#include "footer.ftlh">