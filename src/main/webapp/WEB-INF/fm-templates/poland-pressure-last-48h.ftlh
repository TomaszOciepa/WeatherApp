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
                    <a href="poland-pressure">ostatnia aktualizacja:</a> <b>${lastUpdateString}</b> <br>
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
                                <th scope="col" colspan="3">Ciśnineie maksymalne</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Ciśnienie</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list maxPressureForLast48h as max>
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
                                <th>Ciśnienie</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list minPressureForLast48h as min>
                                <tr>
                                    <td>${min.stationMinPressurePolandStationDateTime}</td>
                                    <td>${min.stationMinPressurePolandStationName}</td>
                                    <td>${min.stationMinPressurePolandStationPressure?c} hPa</td>
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