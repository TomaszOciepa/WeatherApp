package servlet.historicalWeather;

import data.*;
import data.humidity.GetMaxHumidityForPolandLastUpdate;
import data.humidity.GetMinHumidityForPolandLastUpdate;
import data.model.Station;
import data.pressure.GetMaxPressureForPolandLastUpdate;
import data.pressure.GetMinPressureForPolandLastUpdate;
import data.rainfall.GetMaxRainFallForPolandLastUpdate;
import data.rainfall.GetMinRainFallForPolandLastUpdate;
import data.temp.*;
import data.model.GetNameStations;
import data.wind.GetMinWindForPolandLastUpdate;
import data.wind.GetMaxWindForPolandLastUpdate;
import freeMarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = ("weather-for-poland"))
public class WeatherForPolandServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherForPolandServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private GetMaxTempForPolandLastUpdate getMaxTempForPolandLastUpdate;
    @Inject
    private GetMinTempForPolandLastUpdate getMinTempForPolandLastUpdate;
    @Inject
    private GetMaxWindForPolandLastUpdate getMaxWindForPolandLastUpdate;
    @Inject
    private GetMinWindForPolandLastUpdate getMinWindForPolandLastUpdate;
    @Inject
    private GetMaxRainFallForPolandLastUpdate getMaxRainFallForPolandLastUpdate;
    @Inject
    private GetMinRainFallForPolandLastUpdate getMinRainFallForPolandLastUpdate;
    @Inject
    private GetMaxHumidityForPolandLastUpdate getMaxHumidityForPolandLastUpdate;
    @Inject
    private GetMinHumidityForPolandLastUpdate getMinHumidityForPolandLastUpdate;
    @Inject
    private GetMaxPressureForPolandLastUpdate getMaxPressureForPolandLastUpdate;
    @Inject
    private GetMinPressureForPolandLastUpdate getMinPressureForPolandLastUpdate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate =getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        double maxTempForPolandLastUpdate = getMaxTempForPolandLastUpdate.getTemp();
        double minTempForPolandLastUpdate = getMinTempForPolandLastUpdate.getTemp(lastUpdate);
        int maxWindForPolandLastUpdate = getMaxWindForPolandLastUpdate.get(lastUpdate);
        int minWindForPolandLastUpdate = getMinWindForPolandLastUpdate.get(lastUpdate);
        BigDecimal maxRainFallForPolandLastUpdate = getMaxRainFallForPolandLastUpdate.get(lastUpdate);
        BigDecimal minRainFallForPolandLastUpdate = getMinRainFallForPolandLastUpdate.get(lastUpdate);
        double maxHumidityForPolandLastUpdate = getMaxHumidityForPolandLastUpdate.get(lastUpdate);
        double minHumidityForPolandLastUpdate = getMinHumidityForPolandLastUpdate.get(lastUpdate);
        double maxPressureForPolandLastUpdate = getMaxPressureForPolandLastUpdate.get(lastUpdate);
        double minPressureForPolandLastUpdate = getMinPressureForPolandLastUpdate.get(lastUpdate);


        model.put("maxTempForPolandLastUpdate", maxTempForPolandLastUpdate);
        model.put("minTempForPolandLastUpdate", minTempForPolandLastUpdate);
        model.put("maxWindForPolandLastUpdate", maxWindForPolandLastUpdate);
        model.put("minWindForPolandLastUpdate", minWindForPolandLastUpdate);
        model.put("maxRainFallForPolandLastUpdate", maxRainFallForPolandLastUpdate);
        model.put("minRainFallForPolandLastUpdate", minRainFallForPolandLastUpdate);
        model.put("maxHumidityForPolandLastUpdate", maxHumidityForPolandLastUpdate);
        model.put("minHumidityForPolandLastUpdate", minHumidityForPolandLastUpdate);
        model.put("maxPressureForPolandLastUpdate", maxPressureForPolandLastUpdate);
        model.put("minPressureForPolandLastUpdate", minPressureForPolandLastUpdate);
        model.put("lastUpdateString", lastUpdateString);


        template = templateProvider.getTemplate(getServletContext(), "weather-for-poland");
        try {
            LOG.info("Load template weather-for-poland");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template weather-for-poland");
        }
    }
}
