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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = ("weather-for-city-in-poland-last-update-month"))
public class WeatherForCityInPolandLastUpdateMonthServlet extends HttpServlet {

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
        HttpSession session = req.getSession(true);
        String stationName = String.valueOf(session.getAttribute("stationName"));
        LocalDateTime lastUpdate = getLastUpdateDate.get();
        String month = getLastUpdateDate.getStringDateMonth();

        LocalDateTime startDate = LocalDateTime.of(lastUpdate.getYear(), lastUpdate.getMonthValue(), 1, 0, 0);

        List<Station> monthStationWeather = stationDao.getStationDataForDay(stationName, startDate, lastUpdate);
        Map<String, Object> model = new HashMap<>();

        model.put("monthStationWeather", monthStationWeather);
        model.put("stationName", stationName);
        model.put("month", month);



        template = templateProvider.getTemplate(getServletContext(), "weather-for-city-in-poland-last-update-month");
        try {
            LOG.info("Load template weather-for-city-in-poland-last-update-month");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template weather-for-city-in-poland-last-update-month");
        }
    }
}
