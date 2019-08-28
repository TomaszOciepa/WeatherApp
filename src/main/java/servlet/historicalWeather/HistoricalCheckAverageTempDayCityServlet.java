package servlet.historicalWeather;

import convert.DataConverter;
import data.GetAverageTempDayForCity;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = ("historical-check-average-temp-day-city"))
public class HistoricalCheckAverageTempDayCityServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(HistoricalCheckAverageTempDayCityServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private DataConverter dataConverter;
    @Inject
    private GetAverageTempDayForCity getAverageTempDayForCity;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();
        HttpSession session = req.getSession(true);

        String station = String.valueOf(session.getAttribute("station"));
        String day = req.getParameter("day");
        LocalDate date = dataConverter.ChangeStringToLocalData(day);

        double average = getAverageTempDayForCity.get(date, station);

        model.put("average", average);
        model.put("date", date);
        model.put("station", station);

        template = templateProvider.getTemplate(getServletContext(), "historical-check-average-temp-day-city");
        try {
            LOG.info("Load template historical-check-average-temp-day-city");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template historical-check-average-temp-day-city");
        }
    }
}
