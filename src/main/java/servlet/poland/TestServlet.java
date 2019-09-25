package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.*;
import data.model.*;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = ("test"))
public class TestServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PolandTemperatureServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private StationDao stationDao;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMinHumidityPolandDao stationMinHumidityPolandDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate = getLastUpdateDate.get();


        double minTemp;
        List<Station> stationsList = new ArrayList<>();
        LocalDateTime time = lastUpdate.minusHours(1);

        for (int i = 0; i < 844 ; i++) {
            if (i == 0){
               minTemp = stationDao.getMinHumidityForPolandLastUpdate(lastUpdate).get(0).getStationHumidity();
               List<Station> list = stationDao.getCitiesWithHumidity(minTemp, lastUpdate);

                for (int j = 0; j < list.size(); j++) {
                   StationMinHumidityPoland stationMinHumidityPoland = new StationMinHumidityPoland();
                   stationMinHumidityPoland.setStationMinHumidityPolandStationName(list.get(j).getStationName());
                   stationMinHumidityPoland.setStationMinHumidityPolandStationNumber(list.get(j).getStationNumber());
                   stationMinHumidityPoland.setStationMinHumidityPolandStationDateTime(list.get(j).getStationDateTime());
                   stationMinHumidityPoland.setStationMinHumidityPolandStationHumidity(list.get(j).getStationHumidity());
                   stationMinHumidityPolandDao.save(stationMinHumidityPoland);
                }
            }else {
                if (stationDao.getMinHumidityForPolandLastUpdate(time).size() != 0){
                    minTemp = stationDao.getMinHumidityForPolandLastUpdate(time).get(0).getStationHumidity();
                    List<Station> list = stationDao.getCitiesWithHumidity(minTemp, time);

                    for (int j = 0; j < list.size(); j++) {
                        StationMinHumidityPoland stationMinHumidityPoland = new StationMinHumidityPoland();
                        stationMinHumidityPoland.setStationMinHumidityPolandStationName(list.get(j).getStationName());
                        stationMinHumidityPoland.setStationMinHumidityPolandStationNumber(list.get(j).getStationNumber());
                        stationMinHumidityPoland.setStationMinHumidityPolandStationDateTime(list.get(j).getStationDateTime());
                        stationMinHumidityPoland.setStationMinHumidityPolandStationHumidity(list.get(j).getStationHumidity());
                        stationMinHumidityPolandDao.save(stationMinHumidityPoland);
                    }
                }
            }
            time = time.minusHours(1);
        }






        template = templateProvider.getTemplate(getServletContext(), "test");
        try {

            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();

        }
    }
}
