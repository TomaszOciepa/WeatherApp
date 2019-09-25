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
                    ostatnia aktualizacja: <b>${lastUpdateString}</b> <br>
                    <a href="poland-temperature-last-48h">zobacz ostatnie 48h</a> [ licząc od ostatniej aktualizacji ]
                </div>
            </div>
            <hr>
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
                            <#list listCitiesWithMaxTemp as max>
                             <tr>
                                <td>${max.stationMaxTempPolandStationDateTime}</td>
                                <td>${max.stationMaxTempPolandStationName}</td>
                                <td>${max.stationMaxTempPolandStationTemperature?c} &#x2103</td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-sm">
                        <table class="table table-bordered table-dark">
                            <thead>
                            <tr>
                                <th scope="col" colspan="3">Temperatura minimalna</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Temperatura</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list listCitiesWithMinTemp as min>
                                <tr>
                                    <td>${min.stationMinTempPolandStationDateTime}</td>
                                    <td>${min.stationMinTempPolandStationName}</td>
                                    <td>${min.stationMinTempPolandStationTemperature?c} &#x2103</td>
                                </tr>
                            </#list>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftlh">