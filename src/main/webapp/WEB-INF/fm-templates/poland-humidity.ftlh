<#include "header.ftlh">
<div class="wrap">
    <div class="container">
        <#include "menu.ftlh">
        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h2>Wilgotność w Polsce</h2>
                </div>
                <div class="col-sm">
                    ostatnia aktualizacja: <b>${lastUpdateString}</b> <br>
                    <a href="poland-humidity-last-48h">zobacz ostatnie 48h</a> [ licząc od ostatniej aktualizacji ]
                </div>
            </div>
            <hr>
            <div class="poland-main-data">
                <div class="row">
                    <div class="col-sm">
                        <table class="table table-bordered table-dark">
                            <thead>
                            <tr>
                                <th scope="col" colspan="3">Wilgotność maksymalna</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Wilgotność</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list listCitiesWithMaxHumidity as max>
                                <tr>
                                    <td>${max.stationMaxHumidityPolandStationDateTime}</td>
                                    <td>${max.stationMaxHumidityPolandStationName}</td>
                                    <td>${max.stationMaxHumidityPolandStationHumidity} %</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-sm">
                        <table class="table table-bordered table-dark">
                            <thead>
                            <tr>
                                <th scope="col" colspan="3">Wilgotność minimalna</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Wilgotność</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list listCitiesWithMinHumidity  as min>
                                <tr>
                                    <td>${min.stationMinHumidityPolandStationDateTime}</td>
                                    <td>${min.stationMinHumidityPolandStationName}</td>
                                    <td>${min.stationMinHumidityPolandStationHumidity} %</td>
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