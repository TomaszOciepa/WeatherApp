package api;

import javax.json.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;


public class JSON {


    public int createJson() {
        JsonBuilderFactory builderFactory = Json.createBuilderFactory(Collections.emptyMap());
        JsonObject publicationDateObject = builderFactory.createObjectBuilder()
                .add("rok", 2018)
                .add("miesiąc", 9)
                .add("dzień", 13).build();

        JsonObject articleObject = builderFactory.createObjectBuilder()
                .add("tytuł", "Format JSON w języku Java")
                .add("data publikacji", publicationDateObject).build();

        JsonArray articlesArray = builderFactory.createArrayBuilder().add(articleObject).build();

        JsonObject webPageObject = builderFactory.createObjectBuilder()
                .add("adres www", "https://www.samouczekprogramisty.pl")
                .add("artykuły", articlesArray).build();

        JsonObject authorObject = builderFactory.createObjectBuilder()
                .add("imię", "Marcin")
                .add("nazwisko", "Pietraszek")
                .add("strona", webPageObject).build();

        String jsonObject = authorObject.toString();
        InputStream inputStream = new ByteArrayInputStream(jsonObject.getBytes());

        JsonReaderFactory readerFactory = Json.createReaderFactory(Collections.emptyMap());

        try (JsonReader jsonReader = readerFactory.createReader(inputStream)) {
            JsonObject jsonObject1 = jsonReader.readObject();
            return jsonObject1
                    .getJsonObject("strona")
                    .getJsonArray("artykuły")
                    .getJsonObject(0)
                    .getJsonObject("data publikacji")
                    .getInt("rok");

        }


    }
}
