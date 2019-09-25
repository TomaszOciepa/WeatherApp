package servlet.poland;

import data.GetLastUpdateDate;
import data.dao.StationMaxRainPolandDao;
import data.dao.StationMinRainPolandDao;
import data.model.StationMaxRainPoland;
import data.model.StationMinRainPoland;
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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = ("poland-rain-last-48h"))
public class PolandTotalRainFallLast48hServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PolandTotalRainFallLast48hServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private StationMaxRainPolandDao stationMaxRainPolandDao;
    @Inject
    private StationMinRainPolandDao stationMinRainPolandDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Template template;
        Map<String, Object> model = new HashMap<>();

        LocalDateTime lastUpdate = getLastUpdateDate.get();
        String lastUpdateString = getLastUpdateDate.getStringDateTime();

        List<StationMaxRainPoland> stationMaxRainPolandList = getMaxRainPolands(lastUpdate);
        List<StationMinRainPoland> stationMinRainPolandList = getMinRainPolands(lastUpdate);

        model.put("lastUpdateString", lastUpdateString);
        model.put("maxRainForLast48h", stationMaxRainPolandList);
        model.put("minRainForLast48h", stationMinRainPolandList);

        template = templateProvider.getTemplate(getServletContext(), "poland-rain-last-48h");
        try {
            LOG.info("Load template poland-rain-last-48h");
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.warn("No load template poland-rain-last-48h");
        }
    }

    private List<StationMaxRainPoland> getMaxRainPolands (LocalDateTime lastUpdate){
        List<StationMaxRainPoland> stationMaxRainPolandList = new ArrayList<>();

        for (int i = 0; i < 48; i++) {
            if (stationMaxRainPolandDao.getMaxRainPolands(lastUpdate).size() != 0){
                List<StationMaxRainPoland> list = stationMaxRainPolandDao.getMaxRainPolands(lastUpdate);
                for (int j = 0; j < list.size(); j++) {
                    stationMaxRainPolandList.add(list.get(j));
                }
            }else {
                StationMaxRainPoland stationMaxRainPoland = new StationMaxRainPoland();
                stationMaxRainPoland.setStationMaxRainPolandStationDateTime(lastUpdate);
                stationMaxRainPoland.setStationMaxRainPolandStationName("brak pomiaru");
                stationMaxRainPoland.setStationMaxRainPolandStationRain(BigDecimal.ZERO);
                stationMaxRainPolandList.add(stationMaxRainPoland);
            }
            lastUpdate = lastUpdate.minusHours(1);
        }
        return stationMaxRainPolandList;
    }

    private List<StationMinRainPoland> getMinRainPolands(LocalDateTime lastUpdate){
        List<StationMinRainPoland> stationMinRainPolandList = new ArrayList<>();

        for (int i = 0; i < 48; i++) {
            if (stationMinRainPolandDao.getMinRainPolands(lastUpdate).size() != 0){
                List<StationMinRainPoland> list = stationMinRainPolandDao.getMinRainPolands(lastUpdate);
                for (int j = 0; j < list.size(); j++) {
                    stationMinRainPolandList.add(list.get(j));
                }
            }else {
                StationMinRainPoland stationMinRainPoland = new StationMinRainPoland();
                stationMinRainPoland.setStationMinRainPolandStationDateTime(lastUpdate);
                stationMinRainPoland.setStationMinRainPolandStationName("brak pomiaru");
                stationMinRainPoland.setStationMinRainPolandStationRain(BigDecimal.ZERO);
                stationMinRainPolandList.add(stationMinRainPoland);
            }
            lastUpdate = lastUpdate.minusHours(1);
        }
        return stationMinRainPolandList;
    }
}
