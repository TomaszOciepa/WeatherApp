<#include "header.ftlh">

<h1>Historical data weather in Poland</h1>
<p>Last data update: ${lastUpdate}</p>

<a class="btn btn-primary btn-lg" href="historical-select-city" role="button">Select City</a>
<br>
<br>
<br>
<br>
<div class="row">
    <div class="col-3">
        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link active" id="v-pills-average-temperature" data-toggle="pill" href="#v-pills-average-temperature-tab" role="tab" aria-controls="v-pills-average-temperature-tab" aria-selected="true">Average temperature for Poland</a>
            <a class="nav-link" id="v-pills-max-min-temp" data-toggle="pill" href="#v-pills-max-min-temp-tab" role="tab" aria-controls="v-pills-max-min-temp-tab" aria-selected="false">Max and Min temperature</a>
            <a class="nav-link" id="v-pills-average-pressure" data-toggle="pill" href="#v-pills-average-pressure-tab" role="tab" aria-controls="v-pills-average-pressure-tab" aria-selected="false">Average pressure for Poland</a>
            <a class="nav-link" id="v-pills-average-wind-speed" data-toggle="pill" href="#v-pills-average-wind-speed-tab" role="tab" aria-controls="v-pills-average-wind-speed-tab" aria-selected="false">Average wind speed for Poland</a>
            <a class="nav-link" id="v-pills-average-humidity" data-toggle="pill" href="#v-pills-average-humidity-tab" role="tab" aria-controls="v-pills-average-humidity-tab" aria-selected="false">Average humidity for Poland</a>
        </div>
    </div>
    <div class="col-9">
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-average-temperature-tab" role="tabpanel" aria-labelledby="v-pills-average-temperature">
                <h2>Average temperature for poland</h2>
                <p>${average?c} &#x2103</p>
            </div>
            <div class="tab-pane fade" id="v-pills-max-min-temp-tab" role="tabpanel" aria-labelledby="v-pills-max-min-temp">
                <p>Max temperature was ${maxTemp?c} &#x2103  in ${maxTempCity}</p>
                <p>Min temperature was ${minTemp?c} &#x2103  in ${minTempCity}</p>
            </div>
            <div class="tab-pane fade" id="v-pills-average-pressure-tab" role="tabpanel" aria-labelledby="v-pills-average-pressure">
                <p>Average pressure for Poland ${averagePressure} [hPa]</p>
            </div>
            <div class="tab-pane fade" id="v-pills-average-wind-speed-tab" role="tabpanel" aria-labelledby="v-pills-average-wind-speed">
                <p>Average wind speeed for Poland: ${averageWindSpeed} m/s</p>
            </div>
            <div class="tab-pane fade" id="v-pills-average-humidity-tab" role="tabpanel" aria-labelledby="v-pills-average-humidity">
                <p>Average humidity for Poland: ${averageHumidity} </p>
            </div>
        </div>
    </div>
</div>

<#include "footer.ftlh">