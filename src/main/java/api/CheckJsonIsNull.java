package api;

import javax.json.JsonObject;

public class CheckJsonIsNull {

    public String checkJson(String param, JsonObject object){
        String name;
        if (object.isNull(param)){
          return name = "0";
        } else {
            return name = object.getString(param);
        }
    }
}
