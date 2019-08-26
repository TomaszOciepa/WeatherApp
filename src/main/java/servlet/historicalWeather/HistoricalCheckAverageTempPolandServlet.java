package servlet.historicalWeather;

import data.GetAverageTempForPoland;
import data.dao.StationDao;
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
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = ("historical-check-average-temp-poland"))
public class HistoricalCheckAverageTempPolandServlet extends HttpServlet {


    private static final Logger LOG = LoggerFactory.getLogger(HistoricalCheckAverageTempPolandServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetAverageTempForPoland getAverageTempForPoland;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        double average = getAverageTempForPoland.get();

        model.put("average", average);


        template = templateProvider.getTemplate(getServletContext(), "historical-check-average-temp-poland");
        try {
            LOG.info("Load template historical-check-average-temp-poland");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template historical-check-average-temp-poland");
        }
    }
}
