<#include "header.ftlh">
<div class="wrap">
    <div class="container">
        <#include "menu.ftlh">
        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <h2>Wiatr w Polsce</h2>
                </div>
                <div class="col-sm">
                    <a href="poland-wind">ostatnia aktualizacja:</a> <b>${lastUpdateString}</b> <br>
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
                                <th scope="col" colspan="3">Prędkość maksymalna</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Prędkość wiatru</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list maxWindForLast48h as max>
                                <tr>
                                    <td>${max.stationMaxWindPolandStationDateTime}</td>
                                    <td>${max.stationMaxWindPolandStationName}</td>
                                    <td>${max.stationMaxWindPolandStationWind} m/s</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>

                    <div class="col-sm">
                        <table class="table table-bordered table-dark">
                            <thead>
                            <tr>
                                <th scope="col" colspan="3">Prędkość minimalna</th>
                            </tr>
                            <tr>
                                <th>Data</th>
                                <th>Miasto</th>
                                <th>Prędkość wiatru</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list minWindForLast48h as min>
                                <tr>
                                    <td>${min.stationMinWindPolandStationDateTime}</td>
                                    <td>${min.stationMinWindPolandStationName}</td>
                                    <td>${min.stationMinWindPolandStationWind} m/s</td>
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