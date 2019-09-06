package servlet.curentWeather;

import api.FindStation;

import api.GetStation;
import convert.DateConverter;
import data.model.Station;
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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = ("show-weather"))
public class ShowWeatherServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(ShowWeatherServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private FindStation findStation;
    @Inject
    private GetStation getStation;
    @Inject
    private DateConverter dateConverter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        template = templateProvider.getTemplate(getServletContext(), "show-weather");

        String stationName = req.getParameter("station");
        int stationId = findStation.get(stationName);

        Station station = getStation.get(stationId);
        LocalDate localDate = dateConverter.changeLocalDateTimeToLocalDate(station.getStationDateTime());


        Map<String, Object> model = new HashMap<>();
        model.put("cityName", station.getStationName());
        model.put("localDate", localDate);
        model.put("cityHour", station.getStationDateTime().getHour());
        model.put("cityTemperature", station.getStationTemperature());
        model.put("cityWindSpeed", station.getStationWindSpeed());
        model.put("windDirection", station.getStationWindDirection());
        model.put("pressure", station.getStationPressure());
        model.put("humidity", station.getStationHumidity());
        model.put("totalRainfall", station.getStationTotalRainfall());

        try {
            LOG.info("Load template show-weather");
            template.process(model, out);
        } catch (TemplateException e) {
            LOG.warn("No load template show-weather");
            e.printStackTrace();
        }
    }
}
