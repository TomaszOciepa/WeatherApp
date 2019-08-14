<#include "header.ftlh">

<div class="wrap">
    <div class="container">
<div class="jumbotron">
    <h1 class="display-4">Weather service</h1>
    <p class="lead">Check the weather for cities in Poland</p>
    <hr class="my-4">
    <p>We use data https://danepubliczne.imgw.pl/</p>
    <p>${json}</p>
    <a class="btn btn-primary btn-lg" href="#" role="button">Choose a city</a>
</div>

<#include "footer.ftlh">