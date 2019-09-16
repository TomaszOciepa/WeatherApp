<#include "header.ftlh">
<div class="wrap">
    <div class="container">
        <#include "menu.ftlh">
        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h2>Ciśnienie w Polsce</h2>
                    <p>Stan na: <b>${lastUpdateString}</b></p>
                </div>
            </div>

            <div class="poland-main-data">
                <div class="row">
                    <div class="col-sm border-right">
                        <p>Ciśnienie max: <b>${maxPressureForPolandLastUpdate?c} hPa</b> zmierzono w :</p>
                        <#list listCitiesWithMaxPressure as n>
                            <a href="weather-for-city-in-poland?station=${n.stationName}">${n.stationName}</a><br>
                        </#list>
                    </div>
                    <div class="col-sm">
                        <p>Ciśnienie min: <b>${minPressureForPolandLastUpdate?c} hPa</b> zmierzono w :</p>
                        <#list listCitiesWithMinPressure as n>
                            <a href="weather-for-city-in-poland?station=${n.stationName}">${n.stationName}</a><br>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftlh">