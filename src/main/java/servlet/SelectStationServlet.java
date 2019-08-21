package servlet;

import api.GetStationsName;
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

@WebServlet(urlPatterns = ("select-station"))
public class SelectStationServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(SelectStationServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetStationsName getStationsName;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;

        List<String> stationsNameList = getStationsName.get();
        Map<String, Object> model = new HashMap<>();
        model.put("stations", stationsNameList);

        template = templateProvider.getTemplate(getServletContext(), "select-station");
        try {
            LOG.info("Load template select-station");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template select-station");
        }
    }
}
