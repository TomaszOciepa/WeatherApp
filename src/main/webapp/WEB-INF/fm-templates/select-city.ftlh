<form method="get" action="get-weather">
    <div class="form-group">
        <label for="exampleFormControlSelect1">Select City</label>
        <select name="city" class="form-control" id="Select1" required>
            <option></option>
            <#list cities as c>
                <option>${c}</option>
            </#list>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Next</button>
</form>