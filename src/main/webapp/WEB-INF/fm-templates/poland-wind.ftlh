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
                    ostatnia aktualizacja: <b>${lastUpdateString}</b> <br>
                    <a href="poland-wind-last-48h">zobacz ostatnie 48h</a> [ licząc od ostatniej aktualizacji ] <br>
                </div>
            </div>
            <hr>
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
                            <#list listCitiesWithMaxWind as max>
                                <tr>
                                    <td>${max.stationMaxWindPolandStationDateTime}</td>
                                    <td>${max.stationMaxWindPolandStationName}</td>
                                    <td>${max.stationMaxWindPolandStationWind}m/s</td>
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
                            <#list listCitiesWithMinWind as min>
                                <tr>
                                    <td>${min.stationMinWindPolandStationDateTime}</td>
                                    <td>${min.stationMinWindPolandStationName}</td>
                                    <td>${min.stationMinWindPolandStationWind} m/s</td>
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