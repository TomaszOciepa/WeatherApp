package servlet.historicalWeather;

import data.Temp.GetAverageTempYearForCity;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = ("historical-check-average-temp-year-city"))
public class HistoricalCheckAverageTempYearCityServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(HistoricalCheckAverageTempYearCityServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetAverageTempYearForCity getAverageTempYearForCity;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;

        Map<String, Object> model = new HashMap<>();
        HttpSession session = req.getSession(true);
        String station = String.valueOf(session.getAttribute("station"));
        int year = Integer.parseInt(req.getParameter("year"));

        double average =getAverageTempYearForCity.get(year,station);

        model.put("station", station);
        model.put("year", year);
        model.put("average", average);




        template = templateProvider.getTemplate(getServletContext(), "historical-check-average-temp-year-city");
        try {
            LOG.info("Load template historical-check-average-temp-year-city");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template historical-check-average-temp-year-city");
        }
    }
}
