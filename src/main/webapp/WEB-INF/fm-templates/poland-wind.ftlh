<#include "header.ftlh">
<div class="wrap">
    <div class="container">
        <#include "menu.ftlh">
        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h2>Wiatr w Polsce</h2>
                    <p>Stan na: <b>${lastUpdateString}</b></p>
                </div>
            </div>

            <div class="poland-main-data">
                <div class="row">
                    <div class="col-sm border-right">
                        <p>Wiatr max: <b>${maxWindForPolandLastUpdate} m/s</b> zmierzono w :</p>
                        <#list listCitiesWithMaxWind as n>
                            <a href="weather-for-city-in-poland?station=${n.stationName}">${n.stationName}</a><br>
                        </#list>
                    </div>
                    <div class="col-sm">
                        <p>Wiatr min: <b>${minWindForPolandLastUpdate} m/s</b> zmierzono w :</p>
                        <#list listCitiesWithMinWind as n>
                            <a href="weather-for-city-in-poland?station=${n.stationName}">${n.stationName}</a><br>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftlh">