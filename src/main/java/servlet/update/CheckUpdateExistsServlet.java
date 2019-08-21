package servlet.update;

import data.CheckUpdate;
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

@WebServlet(urlPatterns = ("check-update-exists"))
public class CheckUpdateExistsServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateDataServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private CheckUpdate checkUpdate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;

        Map<String, Object> model = new HashMap<>();

        if (checkUpdate.check()){
            model.put("status", "ok");
        }else {
            model.put("status", "no");
        }


        template = templateProvider.getTemplate(getServletContext(), "check-update-exists");
        try {
            LOG.info("Load template check-update-exists");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template check-update-exists");
        }
    }
}
