package servlet.historicalWeather;

import data.GetLastUpdateDate;
import data.dao.StationDao;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = ("weather-for-city-in-poland"))
public class WeatherForCityPolandServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherForCityPolandServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;

        Map<String, Object> model = new HashMap<>();
        String stationName = req.getParameter("station");
        HttpSession session = req.getSession(true);
        session.setAttribute("station", stationName);

        List<Station> station = stationDao.getSelectedCity(stationName);


        LocalDateTime lastUpdate =getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDate();

        Station currentStationWeather = stationDao.getStationDataForHour(stationName, lastUpdate).get(0);

        LocalDateTime startDay = LocalDateTime.of(lastUpdate.getYear(), lastUpdate.getMonthValue(), lastUpdate.getDayOfMonth(), 0, 0 );
        LocalDateTime endDay = LocalDateTime.of(lastUpdate.getYear(), lastUpdate.getMonthValue(), lastUpdate.getDayOfMonth(), 23, 0 );


        List<Station> dayStationWeather = stationDao.getStationDataForDay(stationName, startDay, endDay);



        model.put("currentStationWeather",currentStationWeather);
        model.put("lastUpdateString",lastUpdateString);
        model.put("dayStationWeather",dayStationWeather);


        model.put("station", station);


        template = templateProvider.getTemplate(getServletContext(), "weather-for-city-in-poland");
        try {
            LOG.info("Load template weather-for-city-in-poland");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template weather-for-city-in-poland");
        }
    }

}
