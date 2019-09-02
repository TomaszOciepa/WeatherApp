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
            <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">average temperature for Poland</a>
            <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Max and Min temperature</a>
            <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Average pressure for Poland</a>
            <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Average wind speed for Poland</a>
        </div>
    </div>
    <div class="col-9">
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                <h2>Average temperature for poland</h2>
                <p>${average?c} &#x2103</p>
            </div>
            <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                <p>Max temperature was ${maxTemp?c} &#x2103  in ${maxTempCity}</p>
                <p>Min temperature was ${minTemp?c} &#x2103  in ${minTempCity}</p>
            </div>
            <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                <p>Average pressure for Poland ${averagePressure} [hPa]</p>
            </div>
            <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">
                <p>Average wind speeed for Poland: ${averageWindSpeed} m/s</p>
            </div>
        </div>
    </div>
</div>

<#include "footer.ftlh">