package convert;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Stateless
public class DateConverter {

    public LocalDate changeStringToLocalData(String s){

        String[] array = s.split("-");
        int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);

        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }
    public LocalDate changeLocalDateTimeToLocalDate(LocalDateTime localDateTime){

        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }
}
