<#include "header.ftlh">
<div class="wrap">
    <div class="container">

        <div class="jumbotron jumbotron-color">
            <p><a class="link-main" href="/WeatherApp">Pogodna Apka :)</a></p>
            <h1 class="display-4">Dane publiczne imgw</h1>
            <hr>
            <p>Wybierz miasto i kliknij dalej. Pobierzesz dane bezpośrednio z IMGW.</p>
            <form method="get" action="show-weather">
                <div class="form-group">
                    <select name="station" class="form-control" id="Select1" required>
                        <option>Wybierz miasto</option>
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