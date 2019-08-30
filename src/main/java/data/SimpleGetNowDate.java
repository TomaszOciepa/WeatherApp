package data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Singleton;

@Singleton
public class SimpleGetNowDate {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleGetNowDate.class);
    public String get(){
        return "SimpleGetNow";
    }
}
