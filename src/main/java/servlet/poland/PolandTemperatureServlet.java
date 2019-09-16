package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.model.Station;
import data.temp.GetMaxTempForPolandLastUpdate;
import data.temp.GetMinTempForPolandLastUpdate;
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

@WebServlet(urlPatterns = ("poland-temperature"))
public class PolandTemperatureServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PolandTemperatureServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private GetMaxTempForPolandLastUpdate getMaxTempForPolandLastUpdate;
    @Inject
    private GetMinTempForPolandLastUpdate getMinTempForPolandLastUpdate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate =getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        double maxTempForPolandLastUpdate = getMaxTempForPolandLastUpdate.getTemp();
        List<Station> listCitiesWithMaxTemp = stationDao.getCitiesWithTemp(maxTempForPolandLastUpdate, lastUpdate);

        double minTempForPolandLastUpdate = getMinTempForPolandLastUpdate.getTemp(lastUpdate);
        List<Station> listCitiesWithMinTemp = stationDao.getCitiesWithTemp(minTempForPolandLastUpdate, lastUpdate);

        model.put("lastUpdateString", lastUpdateString);
        model.put("maxTempForPolandLastUpdate", maxTempForPolandLastUpdate);
        model.put("listCitiesWithMaxTemp", listCitiesWithMaxTemp);
        model.put("minTempForPolandLastUpdate", minTempForPolandLastUpdate);
        model.put("listCitiesWithMinTemp", listCitiesWithMinTemp);

        template = templateProvider.getTemplate(getServletContext(), "poland-temperature");
        try {
            LOG.info("Load template poland-temperature");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template poland-temperature");
        }
    }
}
