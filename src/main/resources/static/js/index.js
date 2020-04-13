var BASE_URL = "http://localhost:8090";
var fetchedItems = [];
var PAGING_AND_SORTING_STRING = "?page=0&size=5&sort=itemName,asc";

$(document).ready(function(){
    $("#selector").change(function(){
        var selectedCountry = $(this).children("option:selected").val();
        //alert("You have selected the country - " + selectedCountry);
    });
    fetchAllStoreItems();

});

function fetchAllStoreItems() {
    $.ajax({
        url: BASE_URL+"/items/search-phrase/ "+PAGING_AND_SORTING_STRING,
        type: 'GET',
        dataType: 'json', // added data type
        success: function(res) {
            console.log(res);
            $("#search-result-selector").empty();
            $.each(res.content, function (index, storeItem) {
                var optionString = "<option>"+ storeItem.itemName + " : " + storeItem.itemDescription + "</option>";
                $("#search-result-selector").append(optionString);
            });
            //alert(res);
        },
        error: function (jqXHR, status, err) {
            alert("Local error callback.");
        }
    });
}