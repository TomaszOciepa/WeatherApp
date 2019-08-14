package servlet;


import api.GetCitiesName;
import api.model.City;
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

@WebServlet(urlPatterns = ("select-city"))
public class SelectCityServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetCitiesName getCitiesName;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;

        List<String> citiesList = getCitiesName.getCitiesName();
        Map<String, Object> model = new HashMap<>();
        model.put("cities", citiesList);

        template = templateProvider.getTemplate(getServletContext(), "select-city");
        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
