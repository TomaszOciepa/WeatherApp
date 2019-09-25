package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMaxHumidityPolandDao;
import data.dao.StationMinHumidityPolandDao;
import data.model.StationMaxHumidityPoland;
import data.model.StationMinHumidityPoland;
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

@WebServlet(urlPatterns = ("poland-humidity"))
public class PolandHumidityServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(PolandHumidityServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxHumidityPolandDao stationMaxHumidityPolandDao;
    @Inject
    private StationMinHumidityPolandDao stationMinHumidityPolandDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate =getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();


        List<StationMaxHumidityPoland> stationMaxHumidityPolandList = stationMaxHumidityPolandDao.getMaxHumidityPolands(lastUpdate);
        List<StationMinHumidityPoland> stationMinHumidityPolandList = stationMinHumidityPolandDao.getMinHumidityPolands(lastUpdate);
        model.put("lastUpdateString", lastUpdateString);
        model.put("listCitiesWithMaxHumidity", stationMaxHumidityPolandList);
        model.put("listCitiesWithMinHumidity", stationMinHumidityPolandList);


        template = templateProvider.getTemplate(getServletContext(), "poland-humidity");
        try {
            LOG.info("Load template poland-humidity");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template poland-humidity");
        }
    }
}
