package data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;


public class SimpleTask implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleTask.class);
    @Inject
    private SimpleGetNowDate simpleGetNowDate;
    @Override
    public void run() {
        LOG.info("Run executor");
//        simpleGetNowDate.get();
        String s = get();
        LOG.info("Finish: "+s);

    }

    public String get(){
    return simpleGetNowDate.get();
    }
}
