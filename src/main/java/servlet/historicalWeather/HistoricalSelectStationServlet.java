package servlet.historicalWeather;

import data.dao.StationDao;
import data.model.GetNameStations;
import freeMarker.TemplateProvider;
import freemarker.core.StringArraySequence;
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
import java.util.Set;

@WebServlet(urlPatterns = ("historical-select-city"))
public class HistoricalSelectStationServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(HistoricalSelectStationServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    GetNameStations getNameStations;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        List<String> stationsName = getNameStations.get();

        model.put("name", stationsName);

        template = templateProvider.getTemplate(getServletContext(), "historical-select-city");
        try {
            LOG.info("Load template historical-select-city");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template historical-select-city");
        }
    }
}
