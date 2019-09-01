package servlet.historicalWeather;

import data.GetAverageTempForPoland;
import data.GetLastUpdateDate;
import data.GetMaxTempForPoland;
import data.GetMinTempForPoland;
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
import java.util.Map;

@WebServlet(urlPatterns = ("historical-data"))
public class HistoricalDataServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(HistoricalDataServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetAverageTempForPoland getAverageTempForPoland;
    @Inject
    private GetMaxTempForPoland getMaxTempForPoland;
    @Inject
    private GetMinTempForPoland getMinTempForPoland;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        double average = getAverageTempForPoland.get();
        double maxTemp = getMaxTempForPoland.getMaxTemp();
        String maxTempCity = getMaxTempForPoland.getCity();

        double minTemp = getMinTempForPoland.getMinTemp();
        String minTempCity = getMinTempForPoland.getCity();

        String lastUpdate = getLastUpdateDate.getStringDate();

        model.put("average", average);
        model.put("maxTemp", maxTemp);
        model.put("maxTempCity", maxTempCity);
        model.put("minTemp", minTemp);
        model.put("minTempCity", minTempCity);
        model.put("lastUpdate", lastUpdate);

        template = templateProvider.getTemplate(getServletContext(), "historical-data");
        try {
            LOG.info("Load template historical-data");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template historical-data");
        }
    }
}
