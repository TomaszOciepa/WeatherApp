<script>
    var tempCtx = document.getElementById('TempChart').getContext('2d');
    var temp = new Chart(tempCtx, {
        // The type of chart we want to create
        type: 'bar',

        // The data for our dataset
        data: {
            labels: [<#list monthStationWeather as m>
                '${m.stationDateTime}',
                </#list>],
            datasets: [{
                label: 'Temperatura',
                backgroundColor: 'rgb(76, 127, 4)',
                borderColor: 'rgb(126, 196, 14)',
                data: [<#list monthStationWeather as m>
                    ${m.stationTemperature},
                    </#list>]
            }]
        },

        // Configuration options go here
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        callback: function (value, index, values) {
                            return value + ' ℃ ';
                        }
                    }
                }]
            }
        }
    });

    var windSpeedCtx = document.getElementById('WindSpeedChart').getContext('2d');
    var windSpeed = new Chart(windSpeedCtx, {
        // The type of chart we want to create
        type: 'bar',

        // The data for our dataset
        data: {
            labels: [<#list monthStationWeather as m>
                '${m.stationDateTime}',
                </#list>],
            datasets: [{
                label: 'Wiatr',
                backgroundColor: 'rgb(76, 127, 4)',
                borderColor: 'rgb(126, 196, 14)',
                data: [<#list monthStationWeather as m>
                    ${m.stationWindSpeed},
                    </#list>]
            }]
        },

        // Configuration options go here
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        callback: function (value, index, values) {
                            return value + ' m/s';
                        }
                    }
                }]
            }
        }
    });

    var totalRainFallCtx = document.getElementById('TotalRainFallChart').getContext('2d');
    var totalRainFall = new Chart(totalRainFallCtx, {
        // The type of chart we want to create
        type: 'bar',

        // The data for our dataset
        data: {
            labels: [<#list monthStationWeather as m>
                '${m.stationDateTime}',
                </#list>],
            datasets: [{
                label: 'Suma opadów',
                backgroundColor: 'rgb(76, 127, 4)',
                borderColor: 'rgb(126, 196, 14)',
                data: [<#list monthStationWeather as m>
                    ${m.stationTotalRainfall},
                    </#list>]
            }]
        },

        // Configuration options go here
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        callback: function (value, index, values) {
                            return value + ' mm';
                        }
                    }
                }]
            }
        }
    });

    var humidityCtx = document.getElementById('humidityChart').getContext('2d');
    var humidity = new Chart(humidityCtx, {
        // The type of chart we want to create
        type: 'bar',

        // The data for our dataset
        data: {
            labels: [<#list monthStationWeather as m>
                '${m.stationDateTime}',
                </#list>],
            datasets: [{
                label: 'Wilgotność',
                backgroundColor: 'rgb(76, 127, 4)',
                borderColor: 'rgb(126, 196, 14)',
                data: [<#list monthStationWeather as m>
                    ${m.stationHumidity},
                    </#list>]
            }]
        },

        // Configuration options go here
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        callback: function (value, index, values) {
                            return value + ' %';
                        }
                    }
                }]
            }
        }
    });

    var pressureCtx = document.getElementById('pressureChart').getContext('2d');
    var pressure = new Chart(pressureCtx, {
        // The type of chart we want to create
        type: 'bar',

        // The data for our dataset
        data: {
            labels: [<#list monthStationWeather as m>
                '${m.stationDateTime}',
                </#list>],
            datasets: [{
                label: 'Ciśnienie',
                backgroundColor: 'rgb(76, 127, 4)',
                borderColor: 'rgb(126, 196, 14)',
                data: [<#list monthStationWeather as m>
                    ${m.stationPressure?c},
                    </#list>]
            }]
        },

        // Configuration options go here
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        callback: function (value, index, values) {
                            return value + ' hPa';
                        }
                    }
                }]
            }
        }
    });

</script>

