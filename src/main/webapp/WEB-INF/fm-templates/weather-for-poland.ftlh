<#include "header.ftlh">
<#include "menu.ftlh">
<div class="wrap">
    <div class="container">

        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h2>Dane pogodowe dla Polski</h2>
                    <p>Stan na: <b>${lastUpdateString}</b></p>
                </div>
            </div>
            <hr>
            <div class="poland-main-data">
                <div class="row">
                    <div class="col-sm border-right">
                        <p>Temperatura max: <b>${maxTempForPolandLastUpdate?c} &#x2103</b>
                            <#list listCitiesWithMaxTemp as n>
                                <span>${n.stationName},</span>
                            </#list>
                        </p>
                        <p>Wiatr max: <b>${maxWindForPolandLastUpdate} m/s</b></p>
                        <p>Suma opadu max: <b>${maxRainFallForPolandLastUpdate} mm</b></p>
                        <p>Wilgotność max: <b>${maxHumidityForPolandLastUpdate} %</b></p>
                        <p>Ciśnienie max: <b>${maxPressureForPolandLastUpdate?c} hPa</b></p>
                    </div>
                    <div class="col-sm">
                        <p>Temperatura min: <b>${minTempForPolandLastUpdate?c} &#x2103 </b>
                            <#list listCitiesWithMinTemp as n>
                                <span>${n.stationName},</span>
                            </#list>
                        </p>
                        <p>Wiatr min: <b>${minWindForPolandLastUpdate} m/s</b></p>
                        <p>Suma opadu min: <b>${minRainFallForPolandLastUpdate} mm</b></p>
                        <p>Wilgotność min: <b>${minHumidityForPolandLastUpdate} %</b></p>
                        <p>Ciśnienie min: <b>${minPressureForPolandLastUpdate?c} hPa</b></p>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<#include "footer.ftlh">