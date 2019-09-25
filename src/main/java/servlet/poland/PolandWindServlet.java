package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationMaxWindPolandDao;
import data.dao.StationMinWindPolandDao;
import data.model.StationMaxWindPoland;
import data.model.StationMinWindPoland;
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
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxWindPolandDao stationMaxWindPolandDao;
    @Inject
    private StationMinWindPolandDao stationMinWindPolandDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate =getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        List<StationMaxWindPoland> stationMaxWindPolandList = stationMaxWindPolandDao.getMaxWindPoland(lastUpdate);
        List<StationMinWindPoland> stationMinWindPolandList = stationMinWindPolandDao.getMinWindPoland(lastUpdate);

        model.put("lastUpdateString", lastUpdateString);
        model.put("listCitiesWithMaxWind", stationMaxWindPolandList);
        model.put("listCitiesWithMinWind", stationMinWindPolandList);

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
