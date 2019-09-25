package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationMaxRainPolandDao;
import data.dao.StationMinRainPolandDao;
import data.model.StationMaxRainPoland;
import data.model.StationMinRainPoland;
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

@WebServlet(urlPatterns = ("poland-total-rain-fall"))
public class PolandTotalRainFallServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PolandTotalRainFallServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxRainPolandDao stationMaxRainPolandDao;
    @Inject
    private StationMinRainPolandDao stationMinRainPolandDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate =getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        List<StationMaxRainPoland> stationMaxRainPolandList = stationMaxRainPolandDao.getMaxRainPolands(lastUpdate);
        List<StationMinRainPoland> stationMinRainPolandList = stationMinRainPolandDao.getMinRainPolands(lastUpdate);

        model.put("lastUpdateString", lastUpdateString);
        model.put("listCitiesWithMaxRain", stationMaxRainPolandList);
        model.put("listCitiesWithMinRain", stationMinRainPolandList);

        template = templateProvider.getTemplate(getServletContext(), "poland-total-rain-fall");
        try {
            LOG.info("Load template poland-total-rain-fall");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template poland-total-rain-fall");
        }
    }
}
