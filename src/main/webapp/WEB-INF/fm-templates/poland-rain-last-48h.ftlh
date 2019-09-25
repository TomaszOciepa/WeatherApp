<#include "header.ftlh">
<div class="wrap">
    <div class="container">
        <#include "menu.ftlh">
        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h2>Suma opadów w Polsce</h2>
                </div>
                <div class="col-sm">
                    <a href="poland-total-rain-fall">ostatnia aktualizacja:</a> <b>${lastUpdateString}</b> <br>
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
                                <th scope="col" colspan="3">Opad maksymalny</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Suma opadu</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list maxRainForLast48h as max>
                                <tr>
                                    <td>${max.stationMaxRainPolandStationDateTime}</td>
                                    <td>${max.stationMaxRainPolandStationName}</td>
                                    <td>${max.stationMaxRainPolandStationRain} mm</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>

                    <div class="col-sm">
                        <table class="table table-bordered table-dark">
                            <thead>
                            <tr>
                                <th scope="col" colspan="3">Opad minimalny</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Suma opadu</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list minRainForLast48h as min>
                                <tr>
                                    <td>${min.stationMinRainPolandStationDateTime}</td>
                                    <td>${min.stationMinRainPolandStationName}</td>
                                    <td>${min.stationMinRainPolandStationRain} mm</td>
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