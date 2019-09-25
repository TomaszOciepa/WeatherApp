package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationMaxWindPolandDao;
import data.dao.StationMinWindPolandDao;
import data.model.StationMaxWindPoland;
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

@WebServlet(urlPatterns = ("poland-wind-last-48h"))
public class PolandWindLast48hServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PolandWindLast48hServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxWindPolandDao stationMaxWindPolandDao;
    @Inject
    private StationMinWindPolandDao stationMinWindPolandDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate = getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        List<StationMaxWindPoland> stationMaxWindPolandList = getMaxWindPolands(lastUpdate);
        List<StationMinWindPoland> stationMinWindPolandList = getMinWindPolands(lastUpdate);

        model.put("lastUpdateString", lastUpdateString);
        model.put("maxWindForLast48h", stationMaxWindPolandList);
        model.put("minWindForLast48h", stationMinWindPolandList);

        template = templateProvider.getTemplate(getServletContext(), "poland-wind-last-48h");
        try {
            LOG.info("Load template poland-wind-last-48h");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template poland-wind-last-48h");
        }
    }

    private List<StationMaxWindPoland> getMaxWindPolands (LocalDateTime lastUpdate){
        List<StationMaxWindPoland> stationMaxWindPolandList = new ArrayList<>();

        for (int i = 0; i < 48; i++) {
            if (stationMaxWindPolandDao.getMaxWindPoland(lastUpdate).size() != 0){
                List<StationMaxWindPoland> list = stationMaxWindPolandDao.getMaxWindPoland(lastUpdate);
                for (int j = 0; j < list.size(); j++) {
                    stationMaxWindPolandList.add(list.get(j));
                }
            }else {
                StationMaxWindPoland stationMaxWindPoland = new StationMaxWindPoland();
                stationMaxWindPoland.setStationMaxWindPolandStationDateTime(lastUpdate);
                stationMaxWindPoland.setStationMaxWindPolandStationName("brak pomiaru");
                stationMaxWindPolandList.add(stationMaxWindPoland);
            }
            lastUpdate = lastUpdate.minusHours(1);
        }
        return stationMaxWindPolandList;
    }

    private List<StationMinWindPoland> getMinWindPolands(LocalDateTime lastUpdate){
        List<StationMinWindPoland> stationMinWindPolandList = new ArrayList<>();

        for (int i = 0; i < 48; i++) {
            if (stationMinWindPolandDao.getMinWindPoland(lastUpdate).size() != 0){
                List<StationMinWindPoland> list = stationMinWindPolandDao.getMinWindPoland(lastUpdate);
                for (int j = 0; j < list.size(); j++) {
                    stationMinWindPolandList.add(list.get(j));
                }
            }else {
                StationMinWindPoland stationMinWindPoland = new StationMinWindPoland();
                stationMinWindPoland.setStationMinWindPolandStationDateTime(lastUpdate);
                stationMinWindPoland.setStationMinWindPolandStationName("brak pomiaru");
                stationMinWindPolandList.add(stationMinWindPoland);
            }
            lastUpdate = lastUpdate.minusHours(1);
        }
        return stationMinWindPolandList;
    }
}
