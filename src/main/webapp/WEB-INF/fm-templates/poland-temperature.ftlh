<#include "header.ftlh">
<div class="wrap">
    <div class="container">
        <#include "menu.ftlh">
        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h2>Temperatura powietrza w Polsce</h2>
                    <p>Stan na: <b>${lastUpdateString}</b></p>
                </div>
            </div>

            <div class="poland-main-data">
                <div class="row">
                    <div class="col-sm border-right">
                        <p>Temperatura max: <b>${maxTempForPolandLastUpdate?c} &#x2103</b> zmierzono w :</p>
                        <#list listCitiesWithMaxTemp as n>
                            <a href="weather-for-city-in-poland?station=${n.stationName}">${n.stationName}</a><br>
                        </#list>
                    </div>
                    <div class="col-sm">
                        <p>Temperatura min: <b>${minTempForPolandLastUpdate?c} &#x2103 </b>zmierzono w :</p>
                        <#list listCitiesWithMinTemp as n>
                            <a href="weather-for-city-in-poland?station=${n.stationName}">${n.stationName}</a><br>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftlh">