<#include "header.ftlh">
<div class="wrap">
    <div class="container">
        <#include "menu.ftlh">
        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h2>Ciśnienie w Polsce</h2>
                </div>
                <div class="col-sm">
                    ostatnia aktualizacja: <b>${lastUpdateString}</b> <br>
                    <a href="poland-pressure-last-48h">zobacz ostatnie 48h</a> [ licząc od ostatniej aktualizacji ]
                </div>
            </div>
            <hr>
            <div class="poland-main-data">
                <div class="row">
                    <div class="col-sm">
                        <table class="table table-bordered table-dark">
                            <thead>
                            <tr>
                                <th scope="col" colspan="3">Ciśnienie maksymalne</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Ciśnienie</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list listCitiesWithMaxPressure as max>
                                <tr>
                                    <td>${max.stationMaxPressurePolandStationDateTime}</td>
                                    <td>${max.stationMaxPressurePolandStationName}</td>
                                    <td>${max.stationMaxPressurePolandStationPressure?c} hPa</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-sm">
                        <table class="table table-bordered table-dark">
                            <thead>
                            <tr>
                                <th scope="col" colspan="3">Ciśnienie minimalne</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Ciśnineie</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list listCitiesWithMinPressure  as min>
                                <tr>
                                    <td>${min.stationMinPressurePolandStationDateTime}</td>
                                    <td>${min.stationMinPressurePolandStationName}</td>
                                    <td>${min.stationMinPressurePolandStationPressure?c} hPa</td>
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