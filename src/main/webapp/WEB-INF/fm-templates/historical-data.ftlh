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
                    <form method="get" action="historical-get-weather">
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
                    <h3>Temperatura dla 16 miast wojewódzkich</h3>
                    <p>Stan na: <b>${lastUpdateString}</b></p>
                </div>
            </div>
            <canvas id="myChart" width="400" height="200" aria-label="Hello ARIA World" role="img"></canvas>

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
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'bar',

        // The data for our dataset
        data: {
            labels: [<#list voivodshipCityList as v>
                 '${v.stationName}',
                        </#list>],
    datasets: [{
        label: 'Temperatury',
        backgroundColor: 'rgb(76, 127, 4)',
        borderColor: 'rgb(126, 196, 14)',
        data: [<#list voivodshipCityList as v>
            ${v.stationTemperature},
            </#list>]
    }]
    },

    // Configuration options go here
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    // Include a dollar sign in the ticks
                    callback: function(value, index, values) {
                        return value + ' ℃ ';
                    }
                }
            }]
        }
    }
    })
    ;

</script>
<#include "footer.ftlh">