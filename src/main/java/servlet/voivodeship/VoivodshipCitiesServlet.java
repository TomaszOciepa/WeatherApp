package servlet.voivodeship;

import data.GetLastUpdateDate;
import data.GetVoivodshipCity;
import data.model.Station;
import freeMarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servlet.IndexServlet;

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

@WebServlet(urlPatterns = ("voivodship-cities"))
public class VoivodshipCitiesServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(IndexServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private GetVoivodshipCity getVoivodshipCity;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();
        template = templateProvider.getTemplate(getServletContext(), "voivodship-cities");

        LocalDateTime lastUpdate =getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();
        List<Station> voivodshipCityList =  getVoivodshipCity.get(lastUpdate);

        model.put("voivodshipCityList", voivodshipCityList);
        model.put("lastUpdateString", lastUpdateString);

        try {
            LOG.info("Load template voivodship-cities");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load voivodship-cities");
        }
    }
}
