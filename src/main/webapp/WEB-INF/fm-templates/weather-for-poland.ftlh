<#include "header.ftlh">
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<div class="wrap">
    <div class="container">

        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h1 class="display-4"><a class="link-main" href="/WeatherApp">Pogodna apka :)</a></h1>
                </div>
                <div class="col-sm">
                    <form method="get" action="weather-for-city-in-poland">
                        <div class="form-group">
                            <select name="station" class="form-control" id="Select1" required>
                                <option>wybierz miasto</option>
                                <#list stationsName as n>
                                    <option>${n}</option>
                                </#list>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary button-green">Dalej</button>
                    </form>
                </div>
            </div>
            <hr>


            <div class="row">
                <div class="col-sm">
                    <h2>Dane pogodowe dla Polski</h2>
                    <p>Stan na: <b>${lastUpdateString}</b></p>
                </div>
            </div>

            <div class="poland-main-data">
                <div class="row">
                    <div class="col-sm border-right">
                        <p>Temperatura max: <b>${maxTempForPolandLastUpdate?c} &#x2103</b></p>
                        <p>Wiatr max: <b>${maxWindForPolandLastUpdate} m/s</b></p>
                        <p>Suma opadu max: <b>${maxRainFallForPolandLastUpdate} mm</b></p>
                        <p>Wilgotność max: <b>${maxHumidityForPolandLastUpdate} %</b></p>
                        <p>Ciśnienie max: <b>${maxPressureForPolandLastUpdate?c} hPa</b></p>
                    </div>
                    <div class="col-sm">
                        <p>Temperatura min: <b>${minTempForPolandLastUpdate?c} &#x2103 </b></p>
                        <p>Wiatr min: <b>${minWindForPolandLastUpdate} m/s</b></p>
                        <p>Suma opadu min: <b>${minRainFallForPolandLastUpdate} mm</b></p>
                        <p>Wilgotność min: <b>${minHumidityForPolandLastUpdate} %</b></p>
                        <p>Ciśnienie min: <b>${minPressureForPolandLastUpdate?c} hPa</b></p>
                    </div>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-sm">
                    <h3>Miasta wojewódzkie</h3>
                    <p>Stan na: <b>${lastUpdateString}</b></p>
                </div>
            </div>

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

        <div class="row">
            <div class="col-3">
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="v-pills-average-temperature" data-toggle="pill"
                       href="#v-pills-average-temperature-tab" role="tab"
                       aria-controls="v-pills-average-temperature-tab"
                       aria-selected="true">Average temperature for Poland</a>
                    <a class="nav-link" id="v-pills-max-min-temp" data-toggle="pill" href="#v-pills-max-min-temp-tab"
                       role="tab" aria-controls="v-pills-max-min-temp-tab" aria-selected="false">Max and Min
                        temperature</a>
                    <a class="nav-link" id="v-pills-average-pressure" data-toggle="pill"
                       href="#v-pills-average-pressure-tab" role="tab" aria-controls="v-pills-average-pressure-tab"
                       aria-selected="false">Average pressure for Poland</a>
                    <a class="nav-link" id="v-pills-average-wind-speed" data-toggle="pill"
                       href="#v-pills-average-wind-speed-tab" role="tab" aria-controls="v-pills-average-wind-speed-tab"
                       aria-selected="false">Average wind speed for Poland</a>
                    <a class="nav-link" id="v-pills-average-humidity" data-toggle="pill"
                       href="#v-pills-average-humidity-tab" role="tab" aria-controls="v-pills-average-humidity-tab"
                       aria-selected="false">Average humidity for Poland</a>
                </div>
            </div>
            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-average-temperature-tab" role="tabpanel"
                         aria-labelledby="v-pills-average-temperature">
                        <h2>Average temperature for poland</h2>
                        <p>${average?c} &#x2103</p>
                    </div>
                    <div class="tab-pane fade" id="v-pills-max-min-temp-tab" role="tabpanel"
                         aria-labelledby="v-pills-max-min-temp">
                        <p>Max temperature was ${maxTemp?c} &#x2103 in ${maxTempCity}</p>
                        <p>Min temperature was ${minTemp?c} &#x2103 in ${minTempCity}</p>
                    </div>
                    <div class="tab-pane fade" id="v-pills-average-pressure-tab" role="tabpanel"
                         aria-labelledby="v-pills-average-pressure">
                        <p>Average pressure for Poland ${averagePressure} [hPa]</p>
                    </div>
                    <div class="tab-pane fade" id="v-pills-average-wind-speed-tab" role="tabpanel"
                         aria-labelledby="v-pills-average-wind-speed">
                        <p>Average wind speeed for Poland: ${averageWindSpeed} m/s</p>
                    </div>
                    <div class="tab-pane fade" id="v-pills-average-humidity-tab" role="tabpanel"
                         aria-labelledby="v-pills-average-humidity">
                        <p>Average humidity for Poland: ${averageHumidity} </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "ScriptChartPoland.ftlh">
<#include "footer.ftlh">