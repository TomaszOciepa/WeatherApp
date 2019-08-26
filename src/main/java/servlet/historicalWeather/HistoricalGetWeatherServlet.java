package servlet.historicalWeather;

import data.GetAverageTempForCity;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = ("historical-get-weather"))
public class HistoricalGetWeatherServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(HistoricalGetWeatherServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private StationDao stationDao;
    @Inject
    private GetAverageTempForCity getAverageTempForCity;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;

        Map<String, Object> model = new HashMap<>();
        String stationName = req.getParameter("station");
        List<Station> station = stationDao.getSelectedCity(stationName);
        double average = getAverageTempForCity.get(stationName);

        model.put("station", station);
        model.put("name", station.get(0).getStationName());
        model.put("average", average);

        template = templateProvider.getTemplate(getServletContext(), "historical-get-weather");
        try {
            LOG.info("Load template historical-get-weather");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template historical-get-weather");
        }
    }
}
