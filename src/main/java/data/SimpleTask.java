package data;

import data.dao.StationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTask implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleTask.class);
    StationData stationData = new StationData();
    @Override
    public void run() {
        LOG.info("Run executor");
//        LocalDateTime date = stationData.lastUpdate().get(0).getStationDateTime();
        double date = stationData.getSumTempForPoland().get(0);
        LOG.info("Finish: "+date);
    }
}
