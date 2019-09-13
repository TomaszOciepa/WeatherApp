<#include "header.ftlh">
<#include "menu.ftlh">
<div class="wrap">
    <div class="container">
        <div class="jumbotron jumbotron-color">
            <div class="row">
                <div class="col-sm">
                    <form method="get" action="weather-for-city-in-poland">
                        <div class="form-group">
                            <select name="station" class="form-control" id="Select1" required>
                                <option>wybierz miasto</option>
                                <#list stationsName as n>
                                    <option>${n}</option>
                                </#list>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary button-green">Dalej</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftlh">