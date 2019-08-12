package api.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationResult {

    private StationDetails result;

    public StationResult() {
    }

    public StationDetails getResult() {
        return result;
    }

    public void setResult(StationDetails result) {
        this.result = result;
    }
}
