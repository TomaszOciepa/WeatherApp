package servlet.historicalWeather;

import data.Temp.GetAverageTempMonthForCity;
import data.GetMonthNumber;
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

@WebServlet(urlPatterns = ("historical-check-average-temp-month-city"))
public class HistoricalCheckAverageTempMonthCityServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(HistoricalCheckAverageTempMonthCityServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetMonthNumber getMonthNumber;
    @Inject
    private GetAverageTempMonthForCity getAverageTempMonthForCity;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();
        HttpSession session = req.getSession(true);
        String station = String.valueOf(session.getAttribute("station"));
        String monthStr = req.getParameter("month");
        int monthNumb = getMonthNumber.get(monthStr);
        double average = getAverageTempMonthForCity.get(monthNumb, station);


        model.put("average", average);
        model.put("monthStr", monthStr);
        model.put("station", station);



        template = templateProvider.getTemplate(getServletContext(), "historical-check-average-temp-month-city");
        try {
            LOG.info("Load template historical-check-average-temp-month-city");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template historical-check-average-temp-month-city");
        }
    }
}
