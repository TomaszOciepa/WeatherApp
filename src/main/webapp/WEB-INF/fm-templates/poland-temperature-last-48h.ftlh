<#include "header.ftlh">
<div class="wrap">
    <div class="container">
        <#include "menu.ftlh">
        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h2>Temperatura powietrza w Polsce</h2>
                </div>
                <div class="col-sm">
                  <a href="poland-temperature">ostatnia aktualizacja:</a> <b>${lastUpdateString}</b> <br>
                </div>
            </div>
            <hr>
            <h3>Tabela dla ostatnich 48h [ licząc od ostatniej aktualizacji ]</h3>
            <div class="poland-main-data">
                <div class="row">
                    <div class="col-sm">
                        <table class="table table-bordered table-dark">
                            <thead>
                            <tr>
                                <th scope="col" colspan="3">Temperatura maksymalna</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Temperatura</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list maxTempForLast48h as max>
                                <tr>
                                    <td>${max.stationMaxTempPolandStationDateTime}</td>
                                    <td>${max.stationMaxTempPolandStationName}</td>
                                    <td>${max.stationMaxTempPolandStationTemperature?c} &#x2103</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftlh">