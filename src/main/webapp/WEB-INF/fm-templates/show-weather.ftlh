<#include "header.ftlh">
<div class="wrap">
    <div class="container">

        <div class="jumbotron jumbotron-color">
            <p><a class="link-main" href="/WeatherApp">Pogodna Apka :)</a></p>
            <h1 class="display-4">Dane publiczne imgw</h1>
            <hr>
            <div class="row">
                <div class="col-sm">
                    <div class="title"><h2>${cityName}</h2></div>
                    <p>${localDate}  ${cityHour}:00</p>
                </div>
                <div class="col-sm">
                    <a class="btn btn-primary btn-lg button-green" href="select-station" role="button">inne miasto</a>
                </div>
            </div>
            <div class="weather-info">
                <div class="row">
                    <div class="col-sm border-right">
                        <p>Temperatura: <b>${cityTemperature} &#x2103</b></p>
                        <p>Ciśnienie: <b>${pressure?c} hPa</b></p>
                        <p>Suma opadu: <b>${totalRainfall} mm</b></p>
                    </div>
                    <div class="col-sm">
                        <p>Prędkość wiatru: <b>${cityWindSpeed?c} m/s</b></p>
                        <p>Kierunek wiatru: <b>${windDirection}</b></p>
                        <p>Wilgotność względna: <b>${humidity} %</b></p>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
<#include "footer.ftlh">