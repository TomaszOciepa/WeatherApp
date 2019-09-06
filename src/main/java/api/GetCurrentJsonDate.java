package api;

import convert.DateConverter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GetCurrentJsonDate {

    @Inject
    private GetJsonAll getJsonAll;
    @Inject
    private DateConverter dateConverter;

    public LocalDateTime get() {
        LocalDateTime localDateTime = findHighestDate();

        return localDateTime;
    }


    private LocalDateTime findHighestDate() {
        List<LocalDateTime> localDateTimeList = getDateList();

        LocalDateTime highestDate = localDateTimeList.get(0);

        for (int i = 0; i < localDateTimeList.size(); i++) {

            if (highestDate.isBefore(localDateTimeList.get(i))) {
                highestDate = localDateTimeList.get(i);
            }
        }

        return highestDate;
    }

    private List<LocalDateTime> getDateList() {
        JsonArray jsonArray = getJsonAll.getJson();

        List<LocalDateTime> localDateTimeList = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); i++) {
            String dateStr = jsonArray.getJsonObject(i).getString("data_pomiaru");
            LocalDate localDate = dateConverter.changeStringToLocalData(dateStr);

            int time = Integer.parseInt(jsonArray.getJsonObject(i).getString("godzina_pomiaru"));
            LocalTime localTime = LocalTime.of(time, 0);

            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            localDateTimeList.add(localDateTime);
        }

        return localDateTimeList;
    }
}
