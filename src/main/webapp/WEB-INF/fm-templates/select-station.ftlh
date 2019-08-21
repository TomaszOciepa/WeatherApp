<form method="get" action="get-weather">
    <div class="form-group">
        <label for="exampleFormControlSelect1">Select City</label>
        <select name="station" class="form-control" id="Select1" required>
            <option></option>
            <#list stations as s>
                <option>${s}</option>
            </#list>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Next</button>
</form>