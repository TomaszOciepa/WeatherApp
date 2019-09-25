package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationMaxPressurePolandDao;
import data.dao.StationMinPressurePolandDao;
import data.model.StationMaxPressurePoland;
import data.model.StationMaxTempPoland;
import data.model.StationMinPressurePoland;
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

@WebServlet(urlPatterns = ("poland-pressure-last-48h"))
public class PolandPressureLast48hServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PolandPressureLast48hServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxPressurePolandDao stationMaxPressurePolandDao;
    @Inject
    private StationMinPressurePolandDao stationMinPressurePolandDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate = getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();


        List<StationMaxPressurePoland> stationMaxPressurePolandList = getMaxPressurePolands(lastUpdate);
        List<StationMinPressurePoland> stationMinPressurePolandList = getMinPressurePolands(lastUpdate);

        model.put("lastUpdateString", lastUpdateString);
        model.put("maxPressureForLast48h", stationMaxPressurePolandList);
        model.put("minPressureForLast48h", stationMinPressurePolandList);

        template = templateProvider.getTemplate(getServletContext(), "poland-pressure-last-48h");
        try {
            LOG.info("Load template poland-pressure-last-48h");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template poland-pressure-last-48h");
        }
    }

    private List<StationMaxPressurePoland> getMaxPressurePolands(LocalDateTime lastUpdate) {
        List<StationMaxPressurePoland> stationMaxPressurePolandList = new ArrayList<>();

        for (int i = 0; i < 48; i++) {
            if (stationMaxPressurePolandDao.getMaxPressurePolands(lastUpdate).size() != 0){
                List<StationMaxPressurePoland> list = stationMaxPressurePolandDao.getMaxPressurePolands(lastUpdate);
                for (int j = 0; j < list.size(); j++) {
                    stationMaxPressurePolandList.add(list.get(j));
                }
            }else {
                StationMaxPressurePoland stationMaxPressurePoland = new StationMaxPressurePoland();
                stationMaxPressurePoland.setStationMaxPressurePolandStationDateTime(lastUpdate);
                stationMaxPressurePoland.setStationMaxPressurePolandStationName("brak pomiaru");
                stationMaxPressurePolandList.add(stationMaxPressurePoland);
            }

            lastUpdate = lastUpdate.minusHours(1);
        }
        return stationMaxPressurePolandList;
    }

    private List<StationMinPressurePoland> getMinPressurePolands(LocalDateTime lastUpdate) {
        List<StationMinPressurePoland> stationMinPressurePolandList = new ArrayList<>();

        for (int i = 0; i < 48; i++) {
            if (stationMinPressurePolandDao.getMinPressurePolands(lastUpdate).size() != 0){
                List<StationMinPressurePoland> list = stationMinPressurePolandDao.getMinPressurePolands(lastUpdate);
                for (int j = 0; j < list.size(); j++) {
                    stationMinPressurePolandList.add(list.get(j));
                }
            }else {
                StationMinPressurePoland stationMinPressurePoland = new StationMinPressurePoland();
                stationMinPressurePoland.setStationMinPressurePolandStationDateTime(lastUpdate);
                stationMinPressurePoland.setStationMinPressurePolandStationName("brak pomiaru");
                stationMinPressurePolandList.add(stationMinPressurePoland);
            }

            lastUpdate = lastUpdate.minusHours(1);
        }
        return stationMinPressurePolandList;
    }
}
