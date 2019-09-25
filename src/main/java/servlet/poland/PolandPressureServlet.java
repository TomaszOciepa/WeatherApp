package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationMaxPressurePolandDao;
import data.dao.StationMinPressurePolandDao;
import data.model.StationMaxPressurePoland;
import data.model.StationMinPressurePoland;
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

@WebServlet(urlPatterns = ("poland-pressure"))
public class PolandPressureServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(PolandPressureServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxPressurePolandDao stationMaxPressurePolandDao;
    @Inject
    private StationMinPressurePolandDao stationMinPressurePolandDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate =getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        List<StationMaxPressurePoland> stationMaxPressurePolandList = stationMaxPressurePolandDao.getMaxPressurePolands(lastUpdate);
        List<StationMinPressurePoland> stationMinPressurePolandList = stationMinPressurePolandDao.getMinPressurePolands(lastUpdate);

        model.put("lastUpdateString", lastUpdateString);
        model.put("listCitiesWithMaxPressure", stationMaxPressurePolandList);
        model.put("listCitiesWithMinPressure", stationMinPressurePolandList);

        template = templateProvider.getTemplate(getServletContext(), "poland-pressure");
        try {
            LOG.info("Load template poland-pressure");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template poland-pressure");
        }
    }
}
