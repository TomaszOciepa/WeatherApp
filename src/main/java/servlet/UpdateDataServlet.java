package servlet;

import data.UpdateData;
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

@WebServlet(urlPatterns = ("update-data"))
public class UpdateDataServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateDataServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private UpdateData updateData;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;

        updateData.get();


        Map<String, Object> model = new HashMap<>();

        template = templateProvider.getTemplate(getServletContext(), "update-data");
        try {
            LOG.info("Load template update-data");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template update-data");
        }
    }
}
