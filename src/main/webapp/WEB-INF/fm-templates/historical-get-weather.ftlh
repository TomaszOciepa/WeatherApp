<#include "header.ftlh">

<h1>Historical weather for ${name}</h1>


<div class="accordion" id="accordionExample">
    <div class="card">
        <div class="card-header" id="headingOne">
            <h2 class="mb-0">
                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                    All measurements
                </button>
            </h2>
        </div>

        <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
            <div class="card-body">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">date</th>
                        <th scope="col">Temperature [&#x2103]</th>
                        <th scope="col">Wind speed [m/s]</th>
                        <th scope="col">Wind direction</th>
                        <th scope="col">Pressure [hPa]</th>
                        <th scope="col">Relative humidity</th>
                        <th scope="col">Total Rainfall</th>
                    </tr>
                    </thead>
                    <#list station as s>
                        <tbody>
                        <tr>
                            <td>${s.stationDateTime}</td>
                            <td>${s.stationTemperature}</td>
                            <td>${s.stationWindSpeed?c}</td>
                            <td>${s.stationWindDirection}</td>
                            <td>${s.stationPressure?c}</td>
                            <td>${s.stationHumidity}</td>
                            <td>${s.stationTotalRainfall}</td>
                        </tr>
                        </tbody>
                    </#list>
                </table>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingTwo">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    Average temperature
                </button>
            </h2>
        </div>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
            <div class="card-body">
                ${average?c} &#x2103
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingThree">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    Collapsible Group Item #3
                </button>
            </h2>
        </div>
        <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
            <div class="card-body">
                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
            </div>
        </div>
    </div>
</div>

<#include "footer.ftlh">