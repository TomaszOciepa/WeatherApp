package servlet;

import data.SimpleTask;
import freeMarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
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
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = ("executor"))
public class ExecutorServlet extends HttpServlet {

    @Resource(name ="DefaultManagedScheduledExecutorService")
    ManagedScheduledExecutorService scheduledExecutor;
    private static final Logger LOG = LoggerFactory.getLogger(ExecutorServlet.class);

    @Inject
    private TemplateProvider templateProvider;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();
        template = templateProvider.getTemplate(getServletContext(), "executor");

        ScheduledFuture<?> futureResult = scheduledExecutor. scheduleAtFixedRate (new SimpleTask(),0, 5, TimeUnit.SECONDS);

        while (!futureResult.isDone()) {

            try {

                Thread.sleep(100); // Wait

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }

        try {
            LOG.info("Load template executor");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template executor");
        }
    }
}
