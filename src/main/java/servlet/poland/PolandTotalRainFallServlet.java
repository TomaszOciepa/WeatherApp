package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.model.Station;
import data.rainfall.GetMaxRainFallForPolandLastUpdate;
import data.rainfall.GetMinRainFallForPolandLastUpdate;
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

@WebServlet(urlPatterns = ("poland-total-rain-fall"))
public class PolandTotalRainFallServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PolandTotalRainFallServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private GetMaxRainFallForPolandLastUpdate getMaxRainFallForPolandLastUpdate;
    @Inject
    private GetMinRainFallForPolandLastUpdate getMinRainFallForPolandLastUpdate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate =getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        BigDecimal maxRainFallForPolandLastUpdate = getMaxRainFallForPolandLastUpdate.get(lastUpdate);
        List<Station> listCitiesWithMaxRainFall = stationDao.getCitiesWithRainFall(maxRainFallForPolandLastUpdate, lastUpdate);

        BigDecimal minRainFallForPolandLastUpdate = getMinRainFallForPolandLastUpdate.get(lastUpdate);
        List<Station> listCitiesWithMinRainFall = stationDao.getCitiesWithRainFall(minRainFallForPolandLastUpdate, lastUpdate);

        model.put("lastUpdateString", lastUpdateString);
        model.put("maxRainFallForPolandLastUpdate", maxRainFallForPolandLastUpdate);
        model.put("listCitiesWithMaxRainFall", listCitiesWithMaxRainFall);
        model.put("minRainFallForPolandLastUpdate", minRainFallForPolandLastUpdate);
        model.put("listCitiesWithMinRainFall", listCitiesWithMinRainFall);

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
