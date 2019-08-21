package convert;

import javax.ejb.Stateless;
import java.time.LocalDate;

@Stateless
public class DataConverter {

    public LocalDate ChangeStringToLocalData(String s){

        String[] array = s.split("-");
        int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);

        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }
}
