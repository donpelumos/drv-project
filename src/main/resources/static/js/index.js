$(document).ready(function(){
    $("#selector").change(function(){
        var selectedCountry = $(this).children("option:selected").val();
        //alert("You have selected the country - " + selectedCountry);
    });

    $.ajax({
        url: "Http://localhost:8090/items",
        type: 'GET',
        dataType: 'json', // added data type
        success: function(res) {
            console.log(res);
            $("#search-result-selector").empty();
            $.each(res, function (index, value) {
                var optionString = "<option>"+ value.itemName + " : " + value.itemDescription + "</option>";
                $("#search-result-selector").append(optionString);
            });
            //alert(res);
        },
        error: function (jqXHR, status, err) {
            alert("Local error callback.");
        }
    });
});