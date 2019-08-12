package api.model;


import org.codehaus.jackson.annotate.JsonProperty;

public class RestResponse<T> {

    @JsonProperty("RestResponse")
    private StationsResult<T> stationsResult;

    public RestResponse() {
    }

    public StationsResult<T> getStationsResult() {
        return stationsResult;
    }

    public void setStationsResult(StationsResult<T> stationsResult) {
        this.stationsResult = stationsResult;
    }
}
