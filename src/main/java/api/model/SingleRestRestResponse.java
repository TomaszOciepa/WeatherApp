package api.model;


import org.codehaus.jackson.annotate.JsonProperty;

public class SingleRestRestResponse {

    @JsonProperty("RestResponse")
    private StationResult result;

    public SingleRestRestResponse() {
    }

    public StationResult getResult() {
        return result;
    }

    public void setResult(StationResult result) {
        this.result = result;
    }
}
