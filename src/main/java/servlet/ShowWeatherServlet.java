package servlet;

import api.FindCity;
//import api.GetCity;
import api.GetCity;
import api.GetCityJsonFile;
import api.model.City;

import api.model.CityDetails;
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
import java.util.Map;

@WebServlet(urlPatterns = ("get-weather"))
public class ShowWeatherServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private FindCity findCity;
    @Inject
    private GetCity getCity;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        template = templateProvider.getTemplate(getServletContext(), "show-weather");

        String city = req.getParameter("city");
        City myCity = findCity.get(city);

        CityDetails cityDetails = getCity.get(myCity.getId());



        Map<String, Object> model = new HashMap<>();
        model.put("cityID", cityDetails.getId());
        model.put("cityName", cityDetails.getName());
        model.put("cityDate", cityDetails.getDate());
        model.put("cityTemperature", cityDetails.getTemperature());

        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
