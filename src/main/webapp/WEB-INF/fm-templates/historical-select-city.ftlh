<#include "header.ftlh">

<form method="get" action="historical-get-weather">
    <div class="form-group">
        <label for="exampleFormControlSelect1">Select City</label>
        <select name="station" class="form-control" id="Select1" required>
            <option></option>
            <#list name as n>
                <option>${n}</option>
            </#list>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Next</button>
</form>

<#include "footer.ftlh">