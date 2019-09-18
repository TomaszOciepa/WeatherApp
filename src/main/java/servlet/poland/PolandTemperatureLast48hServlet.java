package servlet.poland;

import data.GetLastUpdateDate;
import data.GetMaxTempForLast48h;
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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = ("poland-temperature-last-48h"))
public class PolandTemperatureLast48hServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(PolandTemperatureLast48hServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private GetMaxTempForLast48h getMaxTempForLast48h;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate = getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        List<Station> maxTempForLast48h = getMaxTempForLast48h.get(lastUpdate);


        model.put("lastUpdateString", lastUpdateString);
        model.put("maxTempForLast48h", maxTempForLast48h);


        template = templateProvider.getTemplate(getServletContext(), "poland-temperature-last-48h");
        try {
            LOG.info("Load template poland-temperature-last-48h");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template poland-temperature-last-48h");
        }
    }
}
