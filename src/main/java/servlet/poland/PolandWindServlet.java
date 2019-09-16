package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.model.Station;
import data.wind.GetMaxWindForPolandLastUpdate;
import data.wind.GetMinWindForPolandLastUpdate;
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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = ("poland-wind"))
public class PolandWindServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PolandWindServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private GetMaxWindForPolandLastUpdate getMaxWindForPolandLastUpdate;
    @Inject
    private GetMinWindForPolandLastUpdate getMinWindForPolandLastUpdate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate =getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        int maxWindForPolandLastUpdate = getMaxWindForPolandLastUpdate.get(lastUpdate);
        List<Station> listCitiesWithMaxWind = stationDao.getCitiesWithWind(maxWindForPolandLastUpdate, lastUpdate);

        int minWindForPolandLastUpdate = getMinWindForPolandLastUpdate.get(lastUpdate);
        List<Station> listCitiesWithMinWind = stationDao.getCitiesWithWind(minWindForPolandLastUpdate, lastUpdate);

        model.put("lastUpdateString", lastUpdateString);
        model.put("maxWindForPolandLastUpdate", maxWindForPolandLastUpdate);
        model.put("listCitiesWithMaxWind", listCitiesWithMaxWind);
        model.put("minWindForPolandLastUpdate", minWindForPolandLastUpdate);
        model.put("listCitiesWithMinWind", listCitiesWithMinWind);

        template = templateProvider.getTemplate(getServletContext(), "poland-wind");
        try {
            LOG.info("Load template poland-wind");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template poland-wind");
        }
    }
}
