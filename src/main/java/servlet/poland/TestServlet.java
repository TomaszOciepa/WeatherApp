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
    private StationMinPressurePolandDao stationMinPressurePolandDao;

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

        for (int i = 0; i < 847 ; i++) {
            if (i == 0){
               minTemp = stationDao.getMinPressureForPolandLastUpdate(lastUpdate).get(0).getStationPressure();
               List<Station> list = stationDao.getCitiesWithPressure(minTemp, lastUpdate);

                for (int j = 0; j < list.size(); j++) {
                   StationMinPressurePoland stationMinPressurePoland = new StationMinPressurePoland();
                   stationMinPressurePoland.setStationMinPressurePolandStationName(list.get(j).getStationName());
                   stationMinPressurePoland.setStationMinPressurePolandStationNumber(list.get(j).getStationNumber());
                   stationMinPressurePoland.setStationMinPressurePolandStationDateTime(list.get(j).getStationDateTime());
                   stationMinPressurePoland.setStationMinPressurePolandStationPressure(list.get(j).getStationPressure());
                   stationMinPressurePolandDao.save(stationMinPressurePoland);
                }
            }else {
                if (stationDao.getMinPressureForPolandLastUpdate(time).size() != 0){
                    minTemp = stationDao.getMinPressureForPolandLastUpdate(time).get(0).getStationPressure();
                    List<Station> list = stationDao.getCitiesWithPressure(minTemp, time);

                    for (int j = 0; j < list.size(); j++) {
                        StationMinPressurePoland stationMinPressurePoland = new StationMinPressurePoland();
                        stationMinPressurePoland.setStationMinPressurePolandStationName(list.get(j).getStationName());
                        stationMinPressurePoland.setStationMinPressurePolandStationNumber(list.get(j).getStationNumber());
                        stationMinPressurePoland.setStationMinPressurePolandStationDateTime(list.get(j).getStationDateTime());
                        stationMinPressurePoland.setStationMinPressurePolandStationPressure(list.get(j).getStationPressure());
                        stationMinPressurePolandDao.save(stationMinPressurePoland);
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
