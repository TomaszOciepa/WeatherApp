<#include "header.ftlh">

<h1>Historical weather for ${name}</h1>


<div class="accordion" id="accordionExample">
    <div class="card">
        <div class="card-header" id="headingOne">
            <h2 class="mb-0">
                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                        aria-expanded="false" aria-controls="collapseOne">
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
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo"
                        aria-expanded="false" aria-controls="collapseTwo">
                    Average temperature for all measurements.
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
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree"
                        aria-expanded="false" aria-controls="collapseThree">
                    Average temperature for selected year.
                </button>
            </h2>
        </div>
        <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
            <div class="card-body">
                <form method="get" action="historical-check-average-temp-year-city">
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Select Year</label>
                        <select name="year" class="form-control" id="SelectYear" required>
                            <option></option>
                            <option>2018</option>
                            <option>2019</option>
                            <option>2020</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Check</button>
                </form>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingThree">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFour"
                        aria-expanded="false" aria-controls="collapseThree">
                    Average temperature for selected month.
                </button>
            </h2>
        </div>
        <div id="collapseFour" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
            <div class="card-body">
                <form method="get" action="historical-check-average-temp-month-city">
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Select Month</label>
                        <select name="month" class="form-control" id="SelectMonth" required>
                            <option></option>
                            <option>January</option>
                            <option>February</option>
                            <option>March</option>
                            <option>April</option>
                            <option>May</option>
                            <option>June</option>
                            <option>July</option>
                            <option>August</option>
                            <option>September</option>
                            <option>October</option>
                            <option>November</option>
                            <option>December</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Check</button>
                </form>
            </div>
        </div>
    </div>
</div>

<#include "footer.ftlh">