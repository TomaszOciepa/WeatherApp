package servlet;

import api.JSON;
import api.WeatherIMGW;
import api.model.StationDetails;
import freeMarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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

@WebServlet(urlPatterns = ("/"))
public class IndexServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        WeatherIMGW weatherIMGW = new WeatherIMGW();
        String stationDetails = weatherIMGW.getAllStations();


        JSON json = new JSON();
        int jsonStr = json.createJson();

        Map<String, Object> model = new HashMap<>();
        model.put("json", stationDetails);


        template = templateProvider.getTemplate(getServletContext(), "index");
        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
