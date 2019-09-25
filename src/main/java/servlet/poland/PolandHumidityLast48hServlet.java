package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationMaxHumidityPolandDao;
import data.dao.StationMinHumidityPolandDao;
import data.model.StationMaxHumidityPoland;
import data.model.StationMinHumidityPoland;
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

@WebServlet(urlPatterns = ("poland-humidity-last-48h"))
public class PolandHumidityLast48hServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PolandHumidityLast48hServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxHumidityPolandDao stationMaxHumidityPolandDao;
    @Inject
    private StationMinHumidityPolandDao stationMinHumidityPolandDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate = getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        List<StationMaxHumidityPoland> stationMaxHumidityPolandList = getMaxHumidityPolands(lastUpdate);
        List<StationMinHumidityPoland> stationMinHumidityPolandList = getMinHumidityPolands(lastUpdate);

        model.put("lastUpdateString", lastUpdateString);
        model.put("maxHumidityForLast48h", stationMaxHumidityPolandList);
        model.put("minHumidityForLast48h", stationMinHumidityPolandList);

        template = templateProvider.getTemplate(getServletContext(), "poland-humidity-last-48h");
        try {
            LOG.info("Load template poland-humidity-last-48h");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template poland-humidity-last-48h");
        }
    }

    private List<StationMaxHumidityPoland> getMaxHumidityPolands (LocalDateTime lastUpdate){
        List<StationMaxHumidityPoland> stationMaxHumidityPolandList = new ArrayList<>();

        for (int i = 0; i < 48; i++) {
            if (stationMaxHumidityPolandDao.getMaxHumidityPolands(lastUpdate).size() != 0){
                List<StationMaxHumidityPoland> list = stationMaxHumidityPolandDao.getMaxHumidityPolands(lastUpdate);
                for (int j = 0; j < list.size(); j++) {
                    stationMaxHumidityPolandList.add(list.get(j));
                }
            }else {
                StationMaxHumidityPoland stationMaxHumidityPoland = new StationMaxHumidityPoland();
                stationMaxHumidityPoland.setStationMaxHumidityPolandStationDateTime(lastUpdate);
                stationMaxHumidityPoland.setStationMaxHumidityPolandStationName("brak pomiaru");
                stationMaxHumidityPolandList.add(stationMaxHumidityPoland);
            }
            lastUpdate = lastUpdate.minusHours(1);
        }
        return stationMaxHumidityPolandList;
    }

    private List<StationMinHumidityPoland> getMinHumidityPolands (LocalDateTime lastUpdate){
        List<StationMinHumidityPoland> stationMinHumidityPolandList = new ArrayList<>();

        for (int i = 0; i < 48; i++) {
            if (stationMinHumidityPolandDao.getMinHumidityPolands(lastUpdate).size() != 0){
                List<StationMinHumidityPoland> list = stationMinHumidityPolandDao.getMinHumidityPolands(lastUpdate);
                for (int j = 0; j < list.size(); j++) {
                    stationMinHumidityPolandList.add(list.get(j));
                }
            }else {
                StationMinHumidityPoland stationMinHumidityPoland = new StationMinHumidityPoland();
                stationMinHumidityPoland.setStationMinHumidityPolandStationDateTime(lastUpdate);
                stationMinHumidityPoland.setStationMinHumidityPolandStationName("brak pomiaru");
                stationMinHumidityPolandList.add(stationMinHumidityPoland);
            }
            lastUpdate = lastUpdate.minusHours(1);
        }
        return stationMinHumidityPolandList;
    }
}
