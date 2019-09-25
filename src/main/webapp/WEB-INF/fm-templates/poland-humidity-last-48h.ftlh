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
                    <a href="poland-humidity">ostatnia aktualizacja:</a> <b>${lastUpdateString}</b> <br>
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
                                <th scope="col" colspan="3">Wilgotność maksymalna</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Wilgotność</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list maxHumidityForLast48h as max>
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
                            <#list minHumidityForLast48h as min>
                                <tr>
                                    <td>${min.stationMinHumidityPolandStationDateTime}</td>
                                    <td>${min.stationMinHumidityPolandStationName}</td>
                                    <td>${min.stationMinHumidityPolandStationHumidity} %</td>
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