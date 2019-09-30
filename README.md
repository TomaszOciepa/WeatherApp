# WeatherApp

The application download data from weather stations in Poland. (62 weather stations in Poland)

* Uses the website `<link>` : https://danepubliczne.imgw.pl  and downloads a JSON file with data.
    JSON file contains information about :
    * station name
    * date of measurement
    * temperature
    * wind speed
    * wind direction
    * humidity
    * pressure
    * total rainfall
    
* JSON file is updated every hour.
* The application checks every hour if an update exists and downloads it.
* Parses the JSON file and writes data to the database.

### Application options
* you can check where is max and min temperature, wind speed, humidity, pressure or total rainfall in Poland. (for the last update or the last 48 hours)
* you can check (the data is presented in the form of a graph) in which voivodships capitals currently have the highest temperature, the strongest wind, the highest pressure, the highest humidity or the highest rainfall.
* you can choose a city and check :
    * current temperature, wind speed, wind direction, pressure, humidity and total rainfall
    * hourly chart for the last 24 hours or selected month with temperature, wind speed, pressure, humidity and total rainfall.   

### Technologies used
    - JAVA EE
    - MAVEN
    - HIBERNATE
    - MySQL
    - FreeMarker
    - JavaScript
    - BOOTSTRAP