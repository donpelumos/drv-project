var BASE_URL = "http://localhost:8090/api";
var fetchedItems = [];
var PAGING_AND_SORTING_STRING = "?page=0&size=5&sort=itemName,asc";
var CURRENT_SORT = "itemName,asc";
var CURRENT_PAGE_SIZE = 5;
var CURRENT_SEARCH_QUERY = "";
var CURRENT_PAGE_NUMBER = 0;

$(document).ready(function(){
    $("#selector").change(function(){
        var selectedCountry = $(this).children("option:selected").val();
        //alert("You have selected the country - " + selectedCountry);
    });

    $("#sort-by").change(function(){
        var selectedSort = $(this).children("option:selected").val();
        CURRENT_SORT = selectedSort;
        CURRENT_PAGE_NUMBER = 0;
    });
    $("#items-per-page").change(function(){
        var selectedPageSize = $(this).children("option:selected").val();
        CURRENT_PAGE_SIZE = parseInt(selectedPageSize);
        CURRENT_PAGE_NUMBER = 0;
    });
    $("#search-button").click(function(){
        CURRENT_SEARCH_QUERY = $("#search-box").val();
        CURRENT_PAGE_NUMBER = 0;
        if(CURRENT_SEARCH_QUERY == null || CURRENT_SEARCH_QUERY == ""){
            CURRENT_SEARCH_QUERY = "%20";
        }
        fetchSearchedItems();
    });
    $("#next-button").click(function(){
        CURRENT_PAGE_NUMBER++;
        fetchSearchedItems();
    });
    $("#prev-button").click(function(){
        CURRENT_PAGE_NUMBER--;
        fetchSearchedItems();
    });
    //fetchAllStoreItems();

});

function fetchSearchedItems(){
    PAGING_AND_SORTING_STRING = "?page="+CURRENT_PAGE_NUMBER+"&size="+CURRENT_PAGE_SIZE+"&sort="+CURRENT_SORT;
    var fullUrl = BASE_URL+"/item/search-query/"+CURRENT_SEARCH_QUERY+PAGING_AND_SORTING_STRING;
    $.ajax({
        url: fullUrl,
        type: 'GET',
        dataType: 'json', // added data type
        success: function(res) {
            console.log(res);
            $("#search-result-selector").empty();
            $.each(res.content, function (index, storeItem) {
                var optionString = `<option value="${storeItem.itemId}"> ${storeItem.itemName} : ${storeItem.itemDescription} </option>`;
                $("#search-result-selector").append(optionString);
            });
            var pageCountEnd = parseInt(res.totalNumberOfPages);
            var pageCountStart = parseInt(res.currentPage)+1;
            var pageCountText= "Page "+pageCountStart + " of "+ pageCountEnd;
            $("#page-count").css({"visibility":"visible"});
            if(pageCountStart == 1 && pageCountEnd == 1){
                $("#prev-button").css({"visibility":"hidden"});
                $("#next-button").css({"visibility":"hidden"});
            }
            else if(pageCountStart == pageCountEnd){
                $("#next-button").css({"visibility":"hidden"});
                $("#prev-button").css({"visibility":"visible"});
            }
            else if(pageCountStart < pageCountEnd && pageCountStart == 1){
                $("#next-button").css({"visibility":"visible"});
                $("#prev-button").css({"visibility":"hidden"});
            }
            else{
                $("#next-button").css({"visibility":"visible"});
                $("#prev-button").css({"visibility":"visible"});
            }

            if(pageCountEnd == 0){
                $("#prev-button").css({"visibility":"hidden"});
                $("#next-button").css({"visibility":"hidden"});
                $("#prev-button").css({"visibility":"hidden"});
                $("#page-count").css({"visibility":"hidden"});
            }
            document.getElementById("page-count").innerHTML = pageCountText;
        },
        error: function (jqXHR, status, err) {
            if(jqXHR.responseJSON == null){
                alert("Unable to connect to service.")
            }
            else {
                var errorResponse = jqXHR.responseJSON;
                alert("ERROR : " + errorResponse.error + ". MESSAGE : " + errorResponse.message);
            }
            //alert("Local error callback.");
        }
    });
}

function fetchAllStoreItems() {
    $.ajax({
        url: BASE_URL+"/item/search-query/ "+PAGING_AND_SORTING_STRING,
        type: 'GET',
        dataType: 'json', // added data type
        success: function(res) {
            console.log(res);
            $("#search-result-selector").empty();
            $.each(res.content, function (index, storeItem) {
                var optionString = `<option value="${storeItem.itemId}"> ${storeItem.itemName} : ${storeItem.itemDescription} </option>`;
                $("#search-result-selector").append(optionString);
            });
            //alert(res);
        },
        error: function (jqXHR, status, err) {
            if(jqXHR.responseJSON == null){
                alert("Unable to connect to service.")
            }
            else {
                var errorResponse = jqXHR.responseJSON;
                alert("ERROR : " + errorResponse.error + ". MESSAGE : " + errorResponse.message);
            }
            //alert("Local error callback.");
        }
    });
}