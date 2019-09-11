package update;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;

@Startup
@Singleton
public class UpdateDate {

    @Resource
    TimerService timerService;

    private static final Logger LOG = LoggerFactory.getLogger(UpdateDate.class);
    @Inject
    private CheckUpdate checkUpdate;
    @Inject
    private UpdateSaveDate updateSaveDate;

    @PostConstruct
    public void initialize() {
        timerService.createTimer(60000, 1800000, "Every half hour timer with 1 min delay");
    }

    @Timeout
    public void programmaticTimeout(Timer timer) {

        if (checkUpdate.check()){
            LOG.info("Update exist");
            updateSaveDate.save();
            LOG.info("Updated date");
        }else {
            LOG.info("Update no exist");
        }

    }
}