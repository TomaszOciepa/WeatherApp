package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationDao;
import data.dao.StationMaxWindPolandDao;
import data.dao.StationMinTempPolandDao;
import data.dao.StationMinWindPolandDao;
import data.model.Station;
import data.model.StationMaxWindPoland;
import data.model.StationMinTempPoland;
import data.model.StationMinWindPoland;
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
    private StationMinWindPolandDao stationMinWindPolandDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate = getLastUpdateDate.get();


        int minTemp = 0;
        LocalDateTime time = lastUpdate.minusHours(1);

        for (int i = 0; i < 837; i++) {
            if (i == 0){

               List<Station> list = stationDao.getCitiesWithWind(minTemp, lastUpdate);

                for (int j = 0; j < list.size(); j++) {
                    StationMinWindPoland stationMinWindPoland = new StationMinWindPoland();
                    stationMinWindPoland.setStationMinWindPolandStationName(list.get(j).getStationName());
                    stationMinWindPoland.setStationMinWindPolandStationNumber(list.get(j).getStationNumber());
                    stationMinWindPoland.setStationMinWindPolandStationDateTime(list.get(j).getStationDateTime());
                    stationMinWindPoland.setStationMinWindPolandStationWind(list.get(j).getStationWindSpeed());
                    stationMinWindPolandDao.save(stationMinWindPoland);
                }
            }else {
                if (stationDao.getMinTempForPolandLastUpdate(time).size() != 0){
                    minTemp = stationDao.getMinWindForPolandLastUpdate(time).get(0).getStationWindSpeed();
                    List<Station> list = stationDao.getCitiesWithWind(minTemp, time);

                    for (int j = 0; j < list.size(); j++) {
                        StationMinWindPoland stationMinWindPoland = new StationMinWindPoland();
                        stationMinWindPoland.setStationMinWindPolandStationName(list.get(j).getStationName());
                        stationMinWindPoland.setStationMinWindPolandStationNumber(list.get(j).getStationNumber());
                        stationMinWindPoland.setStationMinWindPolandStationDateTime(list.get(j).getStationDateTime());
                        stationMinWindPoland.setStationMinWindPolandStationWind(list.get(j).getStationWindSpeed());
                        stationMinWindPolandDao.save(stationMinWindPoland);
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
