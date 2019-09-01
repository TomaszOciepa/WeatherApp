package update;

import api.GetCurrentJsonDate;
import data.GetLastUpdateDate;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Stateless
public class CheckUpdate {

    @Inject
    private GetLastUpdateDate getLastUpdateDate;
    @Inject
    private GetCurrentJsonDate getCurrentJsonDate;

    public Boolean check(){

        LocalDateTime lastDateInDataBase = getLastUpdateDate.get();
        LocalDateTime lasDateJson = getCurrentJsonDate.get();

        if (lastDateInDataBase.isBefore(lasDateJson)){
            return true;
        }else {
            return false;
        }

    }

}
