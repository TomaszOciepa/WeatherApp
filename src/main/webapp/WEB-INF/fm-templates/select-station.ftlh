<#include "header.ftlh">
<div class="wrap">
    <div class="container">

        <div class="jumbotron jumbotron-color">
            <h1 class="display-4"><a class="link-main" href="/WeatherApp">Pogodowa apka :)</a></h1>
            <form method="get" action="show-weather">
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Miasto</label>
                    <select name="station" class="form-control" id="Select1" required>
                        <option></option>
                        <#list stations as s>
                            <option>${s}</option>
                        </#list>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary button-green">Dalej</button>
            </form>
        </div>
    </div>
</div>
<#include "footer.ftlh">